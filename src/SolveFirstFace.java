package com.something.cube;

import com.something.cube.CubeFace.*;
import java.util.HashMap;

public class SolveFirstFace{
    private static HashMap<String, Position> possibleMiddle = new HashMap<String, Position>();
    static {
        possibleMiddle.put("0,1", Position.TOP);
        possibleMiddle.put("1,0", Position.LEFT);
        possibleMiddle.put("1,2", Position.RIGHT);
        possibleMiddle.put("2,1", Position.BOTTOM);
    }

    public static void solve(Cube masterCube, CubeFace currentFace){
        Color currentColor = currentFace.getColor(1, 1);
        while(!doneFace(currentFace)){
            CubeFace topFace = currentFace.getFace(Position.TOP);
            Color topColor = topFace.getColor(1, 1);
            CubeFace bottomFace = currentFace.getFace(Position.BOTTOM);
            Color bottomColor = bottomFace.getColor(1, 1);
            CubeFace rightFace = currentFace.getFace(Position.RIGHT);
            Color rightColor = rightFace.getColor(1, 1);
            CubeFace leftFace = currentFace.getFace(Position.LEFT);
            Color leftColor = leftFace.getColor(1, 1);
            solveMiddlePiece(currentFace, 0, 1, topFace, 2, 1, currentColor, topColor);
        }
    }

    private static void solveMiddlePiece(CubeFace baseFace, int x_base, int y_base,
                                            CubeFace otherFace, int x_other, int y_other,
                                            Color baseColor, Color otherColor){
        String searchString;
        while(!(baseFace.getColor(x_base, y_base) == baseColor && otherFace.getColor(x_other, y_other) == otherColor)){
            if(null != (searchString = searchMiddlePiece(baseFace, baseColor, otherColor))){
                String searchSplitArray = searchString.split(",");
                if(y_base == searchSplitArray[1]){
                    if(x_base == 0){
                        baseFace.getFace(Position.TOP).rotateClock();
                        baseFace.getFace(Position.TOP).rotateClock();
                        baseFace.getFace(Position.BACK).rotateClock();
                        baseFace.getFace(Position.BACK).rotateClock();
                        baseFace.getFace(Position.BOTTOM).rotateClock();
                        baseFace.getFace(Position.BOTTOM).rotateClock();
                    }else{
                        baseFace.getFace(Position.BOTTOM).rotateClock();
                        baseFace.getFace(Position.BOTTOM).rotateClock();
                        baseFace.getFace(Position.BACK).rotateClock();
                        baseFace.getFace(Position.BACK).rotateClock();
                        baseFace.getFace(Position.TOP).rotateClock();
                        baseFace.getFace(Position.TOP).rotateClock();
                    }
                }else if(x_base == searchSplitArray[0]){
                    if(y_base == 0){
                        baseFace.getFace(Position.LEFT).rotateClock();
                        baseFace.getFace(Position.LEFT).rotateClock();
                        baseFace.getFace(Position.BACK).rotateClock();
                        baseFace.getFace(Position.BACK).rotateClock();
                        baseFace.getFace(Position.RIGHT).rotateClock();
                        baseFace.getFace(Position.RIGHT).rotateClock();
                    }else{
                        baseFace.getFace(Position.RIGHT).rotateClock();
                        baseFace.getFace(Position.RIGHT).rotateClock();
                        baseFace.getFace(Position.BACK).rotateClock();
                        baseFace.getFace(Position.BACK).rotateClock();
                        baseFace.getFace(Position.LEFT).rotateClock();
                        baseFace.getFace(Position.LEFT).rotateClock();
                    }
                }else{
					baseFace.getFace(possibleMiddle.get(searchString)).rotateClock();
                }
            }
        }
    }

    private static String searchMiddlePiece(CubeFace currentFace, Color baseColor, Color otherColor){
        for(String possibleString : possibleMiddle.keySet()){
            String splitArray[] = possibleString.split(",");
            if(baseColor == currentFace.getColor(Integer.parseInt(splitArray[0]), Integer.parseInt(splitArray[1]))){
                if(otherColor == currentFace.getFace(possibleMiddle.get(possibleString)).getSide(currentFace)[1]){
                    return possibleString;
                }
            }
        }
        return null;
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
