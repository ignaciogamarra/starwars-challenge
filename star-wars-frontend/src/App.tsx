import DataTable from "./components/DataTable";
import { useState } from "react";
import { useStarshipsApi } from "./hooks/useStarshipsApi";
import "./App.css";
import starWarsLogo from "./assets/star-wars-logo.png";

function App() {
  const { starships, loading, error, refetch } = useStarshipsApi();
  const [sortState, setSortState] = useState<{
    field: string;
    order: "ASC" | "DESC";
  } | null>(null);

  const handleSort = (field: string) => {
    let newOrder: "ASC" | "DESC" = "ASC";

    if (sortState?.field === field && sortState?.order === "ASC") {
      newOrder = "DESC";
    }

    setSortState({ field, order: newOrder });
    refetch(field, newOrder);
    console.log("Sorting in App:", field, newOrder);
  };

  if (loading) {
    return (
      <div className="min-h-screen space-background">
        <div className="min-h-screen space-overlay flex items-center justify-center">
          <div className="text-center">
            <div className="inline-block animate-spin rounded-full h-12 w-12 border-4 border-transparent border-t-yellow-400 border-r-yellow-400 mb-6"></div>
            <p className="text-2xl text-yellow-400 font-semibold mb-2">
              Loading starships...
            </p>
            <p className="text-sm text-gray-400">
              Accessing Imperial database...
            </p>
          </div>
        </div>
      </div>
    );
  }

  if (error) {
    return (
      <div className="min-h-screen space-background">
        <div className="min-h-screen space-overlay flex items-center justify-center">
          <div className="text-center">
            <div className="text-6xl text-red-400 mb-4">⚠️</div>
            <p className="text-2xl text-red-400 font-semibold mb-2">
              Connection failed
            </p>
            <p className="text-sm text-gray-400 mb-4">{error}</p>
            <button
              onClick={() => refetch()}
              className="px-4 py-2 bg-yellow-400 text-black rounded hover:bg-yellow-300 transition-colors"
            >
              Retry Connection
            </button>
          </div>
        </div>
      </div>
    );
  }

  return (
    <div className="min-h-screen space-background">
      <div className="min-h-screen space-overlay">
        <div className="py-12 relative z-10">
          <div className="max-w-[95vw] mx-auto px-4 sm:px-6 lg:px-8">
            {/* Header */}
            <div className="flex items-center mb-16">
              <img
                src={starWarsLogo}
                alt="Star Wars Logo"
                className="star-wars-logo mr-12"
              />
              <div className="text-left">
                <h2 className="text-2xl font-medium text-white mb-3 tracking-wide">
                  Starships Database
                </h2>
                <p className="text-base text-gray-400 max-w-2xl leading-relaxed">
                  A long time ago in a galaxy far, far away... Explore the most
                  iconic starships that shaped the destiny of the galaxy.
                </p>
              </div>
            </div>

            {/* Table Container */}
            <div
              className="star-wars-container rounded-xl p-8 glow-yellow h-[700px] flex flex-col"
              style={{
                boxShadow:
                  "0 0 40px rgba(255, 232, 31, 0.3), 0 0 80px rgba(255, 232, 31, 0.15)",
                border: "1px solid rgba(255, 232, 31, 0.4)",
              }}
            >
              <DataTable
                data={starships}
                onSort={handleSort}
                sortState={sortState}
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
