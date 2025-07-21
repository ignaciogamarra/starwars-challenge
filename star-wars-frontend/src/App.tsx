import DataTable from "./components/DataTable";
import { useState } from "react";
import { useSwapi } from "./hooks/useSwapi";
import type { DataType } from "./hooks/useSwapi";
import "./styles.css";
import starWarsLogo from "./assets/star-wars-logo.png";

function App() {
  const [dataType, setDataType] = useState<DataType>("starships");
  const { data, loading, error, refetch } = useSwapi(dataType);
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

  const handleDataTypeChange = (newType: DataType) => {
    setDataType(newType);
    setSortState(null);
  };

  if (loading) {
    return (
      <div className="min-h-screen space-background">
        <div className="min-h-screen space-overlay flex items-center justify-center">
          <div className="text-center">
            <div className="inline-block animate-spin rounded-full h-12 w-12 border-4 border-transparent border-t-yellow-400 border-r-yellow-400 mb-6"></div>
            <p className="text-2xl text-yellow-400 font-semibold mb-2">
              Loading {dataType}...
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
              <div className="text-left flex-1">
                <h2 className="text-2xl font-medium text-white mb-3 tracking-wide">
                  {dataType === "starships" ? "Starships" : "People"} Database
                </h2>
                <p className="text-base text-gray-400 max-w-2xl leading-relaxed mb-6">
                  A long time ago in a galaxy far, far away... Explore the most
                  iconic{" "}
                  {dataType === "starships"
                    ? "starships that shaped the destiny of the galaxy"
                    : "people from across the galaxy"}
                  .
                </p>

                {/* Radio Buttons */}
                <div className="flex space-x-6">
                  <label className="flex items-center cursor-pointer">
                    <input
                      type="radio"
                      name="dataType"
                      value="starships"
                      checked={dataType === "starships"}
                      onChange={() => handleDataTypeChange("starships")}
                      className="sr-only"
                    />
                    <div
                      className={`w-4 h-4 rounded-full border-2 mr-3 ${
                        dataType === "starships"
                          ? "border-yellow-400 bg-yellow-400"
                          : "border-gray-400"
                      }`}
                    >
                      {dataType === "starships" && (
                        <div className="w-2 h-2 bg-black rounded-full mx-auto mt-0.5"></div>
                      )}
                    </div>
                    <span className="text-white text-sm">Starships</span>
                  </label>

                  <label className="flex items-center cursor-pointer">
                    <input
                      type="radio"
                      name="dataType"
                      value="people"
                      checked={dataType === "people"}
                      onChange={() => handleDataTypeChange("people")}
                      className="sr-only"
                    />
                    <div
                      className={`w-4 h-4 rounded-full border-2 mr-3 ${
                        dataType === "people"
                          ? "border-yellow-400 bg-yellow-400"
                          : "border-gray-400"
                      }`}
                    >
                      {dataType === "people" && (
                        <div className="w-2 h-2 bg-black rounded-full mx-auto mt-0.5"></div>
                      )}
                    </div>
                    <span className="text-white text-sm">People</span>
                  </label>
                </div>
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
                data={data}
                onSort={handleSort}
                sortState={sortState}
                dataType={dataType}
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
