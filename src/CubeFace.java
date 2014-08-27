package com.something.cube;

import java.util.HashMap;

enum Color{
    Green, White, Yellow, Red, Orange, Blue;
}

class CubeFace{
    private HashMap<Position, CubeFace> otherFaces = new HashMap<Position, CubeFace>();
    private Color [][] contentMatrix = new Color[3][3];
    private Color faceColor;
    private Color[] reverse(Color[] inputArray){
        return new Color[]{inputArray[2], inputArray[1], inputArray[0]};
    }

    public enum Position{
        LEFT, RIGHT, TOP, BOTTOM, BACK;
    }

    public CubeFace(Color faceColor){
        if(faceColor == null) throw new IllegalArgumentException();
        this.faceColor = faceColor;
    }
    public String toString(){
        return "Face with "+faceColor.toString()+" Color";
    }
    public String getDetails(){
        StringBuilder retString = new StringBuilder();
        retString.append("Face with "+faceColor.toString()+" Color");
        for(Position position : otherFaces.keySet()){
            retString.append("\n\tSide "+position+" "+otherFaces.get(position));
        }
        return retString.toString();
    }
    public CubeFace getFace(Position position){
        return otherFaces.get(position);
    }
    public void setFace(Position position, CubeFace otherFace){
        otherFaces.put(position, otherFace);
    }
    public Color getColor(int x_index, int y_index){
        if(!(x_index >= 0 && y_index >= 0 && x_index < 3 && y_index < 3)) throw new IllegalArgumentException();
        return contentMatrix[x_index][y_index];
    }
    public void setColor(int x_index, int y_index, Color color){
        if(color == null || !(x_index >= 0 && y_index >= 0 && x_index < 3 && y_index < 3)) throw new IllegalArgumentException();
        System.out.println("Setting color "+color+" at "+x_index+", "+y_index);
        contentMatrix[x_index][y_index] = color;
    }
    public void rotateClock(){
        System.out.println("Rotate "+this);
        Color tempColor = contentMatrix[0][0];
        contentMatrix[0][0] = contentMatrix[2][0];
        contentMatrix[2][0] = contentMatrix[2][2];
        contentMatrix[2][2] = contentMatrix[0][2];
        contentMatrix[0][2] = tempColor;
        tempColor = contentMatrix[0][1];
        contentMatrix[0][1] = contentMatrix[1][0];
        contentMatrix[1][0] = contentMatrix[2][1];
        contentMatrix[2][1] = contentMatrix[1][2];
        contentMatrix[1][2] = tempColor;
        Color[] leftArray = otherFaces.get(Position.LEFT).getSide(this);
        Color[] topArray = otherFaces.get(Position.TOP).getSide(this);
        Color[] rightArray = otherFaces.get(Position.RIGHT).getSide(this);
        Color[] bottomArray = otherFaces.get(Position.BOTTOM).getSide(this);
        if(faceColor == Color.Orange || faceColor == Color.Yellow) otherFaces.get(Position.LEFT).setSide(reverse(bottomArray), this);
        else otherFaces.get(Position.LEFT).setSide(bottomArray, this);
        if(faceColor == Color.Orange || faceColor == Color.White) otherFaces.get(Position.TOP).setSide(reverse(leftArray), this);
        else otherFaces.get(Position.TOP).setSide(leftArray, this);
        if(faceColor == Color.Yellow) otherFaces.get(Position.RIGHT).setSide(reverse(topArray), this);
        else otherFaces.get(Position.RIGHT).setSide(topArray, this);
        if(faceColor == Color.Red || faceColor == Color.White) otherFaces.get(Position.BOTTOM).setSide(reverse(rightArray), this);
        else otherFaces.get(Position.BOTTOM).setSide(rightArray, this);
    }
    public Color[] getSide(CubeFace cubeFace){
        Color[] returnArray = new Color[3];
        Position cubeFacePosition = null;
        for(Position tempPosition : Position.values())
            if(otherFaces.get(tempPosition) == cubeFace){
                cubeFacePosition = tempPosition;
                break;
            }
        switch(cubeFacePosition){
            case LEFT:
                returnArray = new Color[]{contentMatrix[0][0], contentMatrix[1][0], contentMatrix[2][0]};
                break;
            case RIGHT:
                returnArray = new Color[]{contentMatrix[0][2], contentMatrix[1][2], contentMatrix[2][2]};
                break;
            case TOP:
                returnArray = new Color[]{contentMatrix[0][0], contentMatrix[0][1], contentMatrix[0][2]};
                break;
            case BOTTOM:
                returnArray = new Color[]{contentMatrix[2][0], contentMatrix[2][1], contentMatrix[2][2]};
                break;
        }
        return returnArray;
    }
    public void setSide(Color[] setColorArray, CubeFace cubeFace){
        Position cubeFacePosition = null;
        for(Position tempPosition : Position.values())
            if(otherFaces.get(tempPosition) == cubeFace){
                cubeFacePosition = tempPosition;
                break;
            }
        switch(cubeFacePosition){
            case LEFT:
                contentMatrix[0][0] = setColorArray[0];
                contentMatrix[1][0] = setColorArray[1];
                contentMatrix[2][0] = setColorArray[2];
                break;
            case RIGHT:
                contentMatrix[0][2] = setColorArray[0];
                contentMatrix[1][2] = setColorArray[1];
                contentMatrix[2][2] = setColorArray[2];
                break;
            case TOP:
                contentMatrix[0][0] = setColorArray[0];
                contentMatrix[0][1] = setColorArray[1];
                contentMatrix[0][2] = setColorArray[2];
                break;
            case BOTTOM:
                contentMatrix[2][0] = setColorArray[0];
                contentMatrix[2][1] = setColorArray[1];
                contentMatrix[2][2] = setColorArray[2];
                break;
        }
    }
    public void printContents(){
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                sb.append("\n\tColor at "+i+", "+j+" is "+contentMatrix[i][j]);
        System.out.println(sb);
    }
    public void printFullContents(){
        printContents();
        for(Position position : Position.values())
            otherFaces.get(position).printContents();
    }
}
