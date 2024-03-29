package leetcode.queueandstack

class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0

        var result = 0
        grid.forEachIndexed { i, charArray ->
            charArray.forEachIndexed { j, _ ->
                if (grid[i][j] == '1') result += dfs(grid, i, j)
            }
        }
        return result
    }

    private fun dfs(grid: Array<CharArray>, i: Int, j: Int): Int {
        if (i < 0 || j < 0 || i >= grid.size || j >= grid.first().size || grid[i][j] == '0')
            return 0

        grid[i][j] = '0'
        dfs(grid, i + 1, j)
        dfs(grid, i - 1, j)
        dfs(grid, i, j - 1)
        dfs(grid, i, j + 1)
        return 1
    }
}
