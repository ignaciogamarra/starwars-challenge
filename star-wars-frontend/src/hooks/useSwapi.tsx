import { useState, useEffect } from "react";
import type { Starship } from "../types/starship";
import type { Person } from "../types/person";

export type DataType = "starships" | "people";

export function useSwapi(dataType: DataType) {
  const [starships, setStarships] = useState<Starship[]>([]);
  const [people, setPeople] = useState<Person[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  const fetchData = async (field?: string, orderBy?: "ASC" | "DESC") => {
    try {
      setLoading(true);
      setError(null);

      let url = `${import.meta.env.VITE_SWAPI_BASE_URL}${dataType}`;

      if (field && orderBy) {
        url += `?field=${field}&orderBy=${orderBy}`;
      }

      console.log("Fetching from URL:", url);
      const response = await fetch(url);

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      const responseData = await response.json();
      console.log("API Response:", responseData);

      if (dataType === "starships") {
        setStarships(Array.isArray(responseData) ? responseData : []);
      } else {
        setPeople(Array.isArray(responseData) ? responseData : []);
      }
    } catch (err) {
      console.error(`Error fetching ${dataType}:`, err);
      setError(
        err instanceof Error ? err.message : `Failed to fetch ${dataType}`
      );
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchData();
  }, [dataType]);

  return {
    data: dataType === "starships" ? starships : people,
    loading,
    error,
    refetch: fetchData,
  };
}
