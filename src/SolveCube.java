package com.something.cube;

import java.util.HashMap;
import java.io.Console;

class UnrecognizedColorException extends IllegalArgumentException{}

public class SolveCube{
    public static void main(String args[]){
        System.out.println("Hey!!");
        Cube masterCube = new Cube();
        setInputColors(masterCube);
        System.out.println("\nInput Set\nSolve First Layer");
        SolveFirstFace.solve(masterCube, masterCube.getFace(Color.White));
        //interactiveRotate(masterCube);
        //masterCube.getFace(Color.Red).Contents();
        //masterCube.getFace(Color.Red).printFullContents();
        //masterCube.printState();
    }

    private static void interactiveRotate(Cube masterCube){
        String inputString;
        Console console = System.console();
        while(true){
            inputString = console.readLine("Rotate(0) or Print State(1) : ");
            Color inputColor = null;
            for(Color tempColor : Color.values()){
                if(inputString.charAt(1) == tempColor.toString().charAt(0)) inputColor = tempColor;
            }
            if(inputString.charAt(0) == '1') masterCube.getFace(inputColor).printContents();
            else if(inputString.charAt(0) == '0') masterCube.getFace(inputColor).rotateClock();
        }
    }

    private static void setInputColors(Cube masterCube){
        System.out.print("Available colors are ");
        for(Color color : Color.values()){
            System.out.print("|"+color+"|");
        }
        System.out.println();
        for(Color color : Color.values()){
            CubeFace eachFace = masterCube.getFace(color);
            System.out.println("\nSetting colors for "+eachFace);
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i == 1 && j == 1){
                        eachFace.setColor(1, 1, color);
                        continue;
                    }
                    String inputString;
                    Console console = System.console();
                    inputString = console.readLine("Color for position "+i+" , "+j+" is : ");
                    Color inputColor = null;
                    for(Color tempColor : Color.values()){
                        if(inputString.charAt(0) == tempColor.toString().charAt(0)) inputColor = tempColor;
                    }
                    if(inputColor == null) throw new UnrecognizedColorException();
                    eachFace.setColor(i, j, inputColor);
                }
            }
        }
    }
}
