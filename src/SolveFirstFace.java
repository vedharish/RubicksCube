package com.something.cube;

import com.something.cube.CubeFace.*;

public class SolveFirstFace{
    public static void solve(Cube masterCube, CubeFace currentFace){
        Color currentColor = currentFace.get(1, 1);
        while(!doneFace(currentFace)){
            CubeFace topFace = currentFace.getFace(Position.TOP);
            Color topColor = topFace.getColor(1, 1);
            CubeFace bottomFace = currentFace.getFace(Position.BOTTOM);
            Color bottomColor = bottomFace.getColor(1, 1);
            CubeFace rightFace = currentFace.getFace(Position.RIGHT);
            Color rightColor = rightFace.getColor(1, 1);
            CubeFace leftFace = currentFace.getFace(Position.LEFT);
            Color leftColor = leftFace.getColor(1, 1);
        }
    }

    private static Boolean doneFace(CubeFace currentFace){
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if(currentFace.getColor(i, j) != currentFace.getColor(1, 1)) return false;
        CubeFace topFace = currentFace.getFace(Position.TOP);
        if(topFace.getColor(2, 0) != topFace.getColor(1, 1) ||
            topFace.getColor(2, 1) != topFace.getColor(1, 1) ||
            topFace.getColor(2, 2) != topFace.getColor(1, 1)) 
              return false;
        CubeFace bottomFace = currentFace.getFace(Position.BOTTOM);
        if(bottomFace.getColor(0, 0) != bottomFace.getColor(1, 1) ||
            bottomFace.getColor(0, 1) != bottomFace.getColor(1, 1) ||
            bottomFace.getColor(0, 2) != bottomFace.getColor(1, 1))
              return false;
        CubeFace rightFace = currentFace.getFace(Position.RIGHT);
        if(rightFace.getColor(0, 0) != rightFace.getColor(1, 1) ||
            rightFace.getColor(1, 0) != rightFace.getColor(1, 1) ||
            rightFace.getColor(2, 0) != rightFace.getColor(1, 1))
              return false;
        CubeFace leftFace = currentFace.getFace(Position.LEFT);
        if(leftFace.getColor(0, 2) != leftFace.getColor(1, 1) ||
            leftFace.getColor(1, 2) != leftFace.getColor(1, 1) ||
            leftFace.getColor(2, 2) != leftFace.getColor(1, 1))
              return false;
        return true;
    }
}
