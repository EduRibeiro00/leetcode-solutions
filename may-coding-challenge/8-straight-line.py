# You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

# Example 1:

# Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
# Output: true
# Example 2:

# Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
# Output: false
 
# Constraints:

# 2 <= coordinates.length <= 1000
# coordinates[i].length == 2
# -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
# coordinates contains no duplicate point.

class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        slope = -1
        first = True
        for idx in range(1, len(coordinates)):
            cur_point = coordinates[idx]
            prev_point = coordinates[idx-1]
            cur_change_x = cur_point[0] - prev_point[0]
            cur_change_y = cur_point[1] - prev_point[1]
            if first:
                slope = self.calcSlope(cur_change_x, cur_change_y)
                first = False
            else:
                cur_slope = self.calcSlope(cur_change_x, cur_change_y)
                if cur_slope != slope:
                    return False
        
        return True
    
    def calcSlope(self, change_x, change_y):
        if change_x == 0:
            return 999999999
        return change_y / change_x