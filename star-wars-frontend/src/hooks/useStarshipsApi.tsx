import { useState, useEffect } from "react";
import type { Starship } from "../types/starship";

export function useStarshipsApi() {
  const [starships, setStarships] = useState<Starship[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  const fetchStarships = async (field?: string, orderBy?: "ASC" | "DESC") => {
    try {
      setLoading(true);
      setError(null);

      let url = import.meta.env.VITE_SWAPI_BASE_URL;

      if (field && orderBy) {
        url += `?field="${field}"&orderBy="${orderBy}"`;
      }

      const response = await fetch(url, {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
        cache: "no-cache", // Prevent caching issues
      });

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      const data = await response.json();
      console.log("API Response:", data);
      setStarships(Array.isArray(data) ? data : []);
    } catch (err) {
      console.error("Error fetching starships:", err);
      setError(
        err instanceof Error ? err.message : "Failed to fetch starships"
      );
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchStarships();
  }, []);

  return {
    starships,
    loading,
    error,
    refetch: fetchStarships,
  };
}
