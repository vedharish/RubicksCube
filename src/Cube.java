package com.something.cube;

import java.util.HashMap;

class Cube{
    HashMap<Color, CubeFace> faceMap = new HashMap<Color, CubeFace>();
    public Cube(){
        for(Color color : Color.values()){
            faceMap.put(color, new CubeFace(color));
        }
        initializeFacePositions(faceMap);
    }

    private void initializeFacePositions(HashMap<Color, CubeFace> faceMap){
        faceMap.get(Color.White).setFace(CubeFace.Position.LEFT, faceMap.get(Color.Orange));
        faceMap.get(Color.White).setFace(CubeFace.Position.RIGHT, faceMap.get(Color.Red));
        faceMap.get(Color.White).setFace(CubeFace.Position.TOP, faceMap.get(Color.Blue));
        faceMap.get(Color.White).setFace(CubeFace.Position.BOTTOM, faceMap.get(Color.Green));
        faceMap.get(Color.White).setFace(CubeFace.Position.BACK, faceMap.get(Color.Yellow));
        //System.out.println(faceMap.get(Color.White).getDetails());
        faceMap.get(Color.Red).setFace(CubeFace.Position.LEFT, faceMap.get(Color.White));
        faceMap.get(Color.Red).setFace(CubeFace.Position.RIGHT, faceMap.get(Color.Yellow));
        faceMap.get(Color.Red).setFace(CubeFace.Position.TOP, faceMap.get(Color.Blue));
        faceMap.get(Color.Red).setFace(CubeFace.Position.BOTTOM, faceMap.get(Color.Green));
        faceMap.get(Color.Red).setFace(CubeFace.Position.BACK, faceMap.get(Color.Orange));
        //System.out.println(faceMap.get(Color.Red).getDetails());
        faceMap.get(Color.Yellow).setFace(CubeFace.Position.LEFT, faceMap.get(Color.Red));
        faceMap.get(Color.Yellow).setFace(CubeFace.Position.RIGHT, faceMap.get(Color.Orange));
        faceMap.get(Color.Yellow).setFace(CubeFace.Position.TOP, faceMap.get(Color.Blue));
        faceMap.get(Color.Yellow).setFace(CubeFace.Position.BOTTOM, faceMap.get(Color.Green));
        faceMap.get(Color.Yellow).setFace(CubeFace.Position.BACK, faceMap.get(Color.White));
        //System.out.println(faceMap.get(Color.Yellow).getDetails());
        faceMap.get(Color.Orange).setFace(CubeFace.Position.LEFT, faceMap.get(Color.Yellow));
        faceMap.get(Color.Orange).setFace(CubeFace.Position.RIGHT, faceMap.get(Color.White));
        faceMap.get(Color.Orange).setFace(CubeFace.Position.TOP, faceMap.get(Color.Blue));
        faceMap.get(Color.Orange).setFace(CubeFace.Position.BOTTOM, faceMap.get(Color.Green));
        faceMap.get(Color.Orange).setFace(CubeFace.Position.BACK, faceMap.get(Color.Red));
        //System.out.println(faceMap.get(Color.Orange).getDetails());
        faceMap.get(Color.Blue).setFace(CubeFace.Position.LEFT, faceMap.get(Color.Orange));
        faceMap.get(Color.Blue).setFace(CubeFace.Position.RIGHT, faceMap.get(Color.Red));
        faceMap.get(Color.Blue).setFace(CubeFace.Position.TOP, faceMap.get(Color.Yellow));
        faceMap.get(Color.Blue).setFace(CubeFace.Position.BOTTOM, faceMap.get(Color.White));
        faceMap.get(Color.Blue).setFace(CubeFace.Position.BACK, faceMap.get(Color.Green));
        //System.out.println(faceMap.get(Color.Blue).getDetails());
        faceMap.get(Color.Green).setFace(CubeFace.Position.LEFT, faceMap.get(Color.Orange));
        faceMap.get(Color.Green).setFace(CubeFace.Position.RIGHT, faceMap.get(Color.Red));
        faceMap.get(Color.Green).setFace(CubeFace.Position.TOP, faceMap.get(Color.White));
        faceMap.get(Color.Green).setFace(CubeFace.Position.BOTTOM, faceMap.get(Color.Yellow));
        faceMap.get(Color.Green).setFace(CubeFace.Position.BACK, faceMap.get(Color.Blue));
        //System.out.println(faceMap.get(Color.Green).getDetails());
    }
    public CubeFace getFace(Color color){
        return faceMap.get(color);
    }
    public void printState(){
        for(CubeFace eachFace : faceMap.values()){
            eachFace.printContents();
        }
    }
}

