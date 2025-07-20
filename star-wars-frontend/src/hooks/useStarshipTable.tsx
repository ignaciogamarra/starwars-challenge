import { useMemo } from "react";
import {
  useReactTable,
  getCoreRowModel,
  createColumnHelper,
} from "@tanstack/react-table";
import type { Starship } from "../types/starship";

const columnHelper = createColumnHelper<Starship>();

export function useStarshipTable(data: Starship[]) {
  const columns = useMemo(
    () => [
      columnHelper.accessor("name", {
        header: "Name",
        enableSorting: true,
        cell: (info) => (
          <div className="font-medium text-yellow-400">{info.getValue()}</div>
        ),
      }),
      columnHelper.accessor("model", {
        header: "Model",
        enableSorting: true,
        cell: (info) => <div className="text-gray-400">{info.getValue()}</div>,
      }),
      columnHelper.accessor("manufacturer", {
        header: "Manufacturer",
        enableSorting: true,
        cell: (info) => (
          <div
            className="text-gray-400 max-w-xs truncate"
            title={info.getValue()}
          >
            {info.getValue()}
          </div>
        ),
      }),
      columnHelper.accessor("cost_in_credits", {
        header: "Cost (Credits)",
        cell: (info) => {
          const value = info.getValue();
          return (
            <div className="text-gray-300 font-mono text-sm">
              {value === "unknown"
                ? "Unknown"
                : `${parseInt(value).toLocaleString()}`}
            </div>
          );
        },
      }),
      columnHelper.accessor("length", {
        header: "Length (m)",
        cell: (info) => (
          <div className="text-gray-300 font-mono text-sm">
            {info.getValue()}m
          </div>
        ),
      }),
      columnHelper.accessor("crew", {
        header: "Crew",
        cell: (info) => (
          <div className="text-gray-400 text-sm">{info.getValue()}</div>
        ),
      }),
      columnHelper.accessor("passengers", {
        header: "Passengers",
        cell: (info) => (
          <div className="text-gray-400 text-sm">{info.getValue()}</div>
        ),
      }),
      columnHelper.accessor("max_atmosphering_speed", {
        header: "Max Speed",
        enableSorting: true,
        cell: (info) => {
          const value = info.getValue();
          return (
            <div className="text-gray-300 font-mono text-sm">
              {value === "unknown" || value === "n/a"
                ? "Unknown"
                : `${value} km/h`}
            </div>
          );
        },
      }),
      columnHelper.accessor("cargo_capacity", {
        header: "Cargo (kg)",
        enableSorting: true,
        cell: (info) => {
          const value = info.getValue();
          return (
            <div className="text-gray-300 font-mono text-sm">
              {value === "unknown" || value === "n/a"
                ? "Unknown"
                : `${parseInt(value).toLocaleString()}`}
            </div>
          );
        },
      }),
      columnHelper.accessor("consumables", {
        header: "Consumables",
        cell: (info) => (
          <div className="text-gray-400 text-sm">{info.getValue()}</div>
        ),
      }),
      columnHelper.accessor("hyperdrive_rating", {
        header: "Hyperdrive",
        enableSorting: true,
        cell: (info) => {
          const value = info.getValue();
          return (
            <div className="text-gray-300 font-mono text-sm">
              {value === "unknown" || value === "n/a"
                ? "Unknown"
                : `Class ${value}`}
            </div>
          );
        },
      }),
      columnHelper.accessor("MGLT", {
        header: "MGLT",
        enableSorting: true,
        cell: (info) => {
          const value = info.getValue();
          return (
            <div className="text-gray-300 font-mono text-sm">
              {value === "unknown" || value === "n/a" ? "Unknown" : value}
            </div>
          );
        },
      }),
      columnHelper.accessor("films", {
        header: "Films",
        cell: (info) => {
          const films = info.getValue() as string[];
          return (
            <div className="text-gray-400 text-sm">
              {films?.length || 0} film{films?.length !== 1 ? "s" : ""}
            </div>
          );
        },
      }),
      columnHelper.accessor("pilots", {
        header: "Pilots",
        cell: (info) => {
          const pilots = info.getValue() as string[];
          return (
            <div className="text-gray-400 text-sm">
              {pilots?.length || 0} pilot{pilots?.length !== 1 ? "s" : ""}
            </div>
          );
        },
      }),
      columnHelper.accessor("starship_class", {
        header: "Class",
        cell: (info) => (
          <div className="inline-flex px-3 py-1 text-xs font-medium bg-gray-800/60 text-yellow-300 border border-gray-700/50 rounded-full capitalize">
            {info.getValue()}
          </div>
        ),
      }),
    ],
    []
  );

  const table = useReactTable({
    data,
    columns,
    getCoreRowModel: getCoreRowModel(),
    manualSorting: true,
  });

  return {
    table,
  };
}
