import { useMemo } from "react";
import {
  useReactTable,
  getCoreRowModel,
  createColumnHelper,
} from "@tanstack/react-table";
import type { Person } from "../types/person";

const columnHelper = createColumnHelper<Person>();

export function usePeopleTable(data: Person[]) {
  const columns = useMemo(
    () => [
      columnHelper.accessor("name", {
        header: "Name",
        enableSorting: true,
        cell: (info) => (
          <div className="font-medium text-yellow-400">{info.getValue()}</div>
        ),
      }),
      columnHelper.accessor("created", {
        header: "Created",
        enableSorting: true,
        cell: (info) => (
            <div className="text-gray-400 text-sm">{info.getValue()}</div>
        ),
      }),
      columnHelper.accessor("height", {
        header: "Height",
        enableSorting: true,
        cell: (info) => {
          const height = info.getValue();
          return (
            <div className="text-gray-300 font-mono text-sm">
              {height === "unknown" ? "Unknown" : `${height} cm`}
            </div>
          );
        },
      }),
      columnHelper.accessor("mass", {
        header: "Mass",
        enableSorting: true,
        cell: (info) => {
          const mass = info.getValue();
          return (
            <div className="text-gray-300 font-mono text-sm">
              {mass === "unknown" ? "Unknown" : `${mass} kg`}
            </div>
          );
        },
      }),
      columnHelper.accessor("hairColor", {
        header: "Hair Color",
        enableSorting: true,
        cell: (info) => (
          <div className="text-gray-400 capitalize">
            {info.getValue() === "n/a" ? "N/A" : info.getValue()}
          </div>
        ),
      }),
      columnHelper.accessor("skinColor", {
        header: "Skin Color",
        enableSorting: true,
        cell: (info) => (
          <div className="text-gray-400 capitalize">{info.getValue()}</div>
        ),
      }),
      columnHelper.accessor("eyeColor", {
        header: "Eye Color",
        enableSorting: true,
        cell: (info) => (
          <div className="text-gray-400 capitalize">{info.getValue()}</div>
        ),
      }),
      columnHelper.accessor("birthYear", {
        header: "Birth Year",
        enableSorting: true,
        cell: (info) => <div className="text-gray-400">{info.getValue()}</div>,
      }),
      columnHelper.accessor("gender", {
        header: "Gender",
        enableSorting: true,
        cell: (info) => (
          <div className="text-gray-400 capitalize">
            {info.getValue() === "n/a" ? "N/A" : info.getValue()}
          </div>
        ),
      }),
      columnHelper.accessor("films", {
        header: "Films",
        cell: (info) => {
          const films = info.getValue() as string[];
          return (
            <div className="text-blue-400 text-sm">
              {films?.length || 0} film{films?.length !== 1 ? "s" : ""}
            </div>
          );
        },
      }),
      columnHelper.accessor("species", {
        header: "Species",
        cell: (info) => {
          const species = info.getValue() as string[];
          return (
            <div className="text-green-400 text-sm">{species?.length || 0}</div>
          );
        },
      }),
      columnHelper.accessor("vehicles", {
        header: "Vehicles",
        cell: (info) => {
          const vehicles = info.getValue() as string[];
          return (
            <div className="text-orange-400 text-sm">
              {vehicles?.length || 0}
            </div>
          );
        },
      }),
      columnHelper.accessor("starships", {
        header: "Starships",
        cell: (info) => {
          const starships = info.getValue() as string[];
          return (
            <div className="text-purple-400 text-sm">
              {starships?.length || 0}
            </div>
          );
        },
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
