import { flexRender } from "@tanstack/react-table";
import type { Starship } from "../types/starship";
import { useStarshipTable } from "../hooks/useStarshipTable";

interface DataTableProps {
  data: Starship[];
  onSort: (field: string) => void;
  sortState: { field: string; order: "ASC" | "DESC" } | null;
}

export default function DataTable({ data, onSort, sortState }: DataTableProps) {
  const { table } = useStarshipTable(data);
  const columns = table.getAllColumns();

  const handleSort = (columnId: string) => {
    onSort(columnId);
  };

  return (
    <div className="w-full h-full flex flex-col overflow-hidden">
      <div className="flex-1 overflow-x-auto">
        <table className="min-w-full h-full">
          <thead className="bg-gray-900/60">
            {table.getHeaderGroups().map((headerGroup) => (
              <tr key={headerGroup.id}>
                {headerGroup.headers.map((header) => (
                  <th
                    key={header.id}
                    className="px-6 py-4 text-left text-xs font-medium text-yellow-400 uppercase tracking-wider cursor-pointer hover:bg-gray-800/40 transition-colors select-none border-b border-gray-700/50"
                    onClick={() => handleSort(header.column.id)}
                  >
                    <div className="flex items-center space-x-2">
                      <span>
                        {header.isPlaceholder
                          ? null
                          : flexRender(
                              header.column.columnDef.header,
                              header.getContext()
                            )}
                      </span>
                      <span className="text-yellow-400/60">
                        {sortState?.field === header.column.id
                          ? sortState?.order === "ASC"
                            ? "↑"
                            : "↓"
                          : "↕"}
                      </span>
                    </div>
                  </th>
                ))}
              </tr>
            ))}
          </thead>
          <tbody className="divide-y divide-gray-700/30">
            {table.getRowModel().rows.length === 0 ? (
              <tr>
                <td
                  colSpan={columns.length}
                  className="px-6 py-16 text-center text-gray-400"
                >
                  No starships found in this sector of the galaxy.
                </td>
              </tr>
            ) : (
              table.getRowModel().rows.map((row) => (
                <tr
                  key={row.id}
                  className="hover:bg-gray-800/20 transition-colors"
                >
                  {row.getVisibleCells().map((cell) => (
                    <td key={cell.id} className="px-6 py-5 whitespace-nowrap">
                      {flexRender(
                        cell.column.columnDef.cell,
                        cell.getContext()
                      )}
                    </td>
                  ))}
                </tr>
              ))
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
}
