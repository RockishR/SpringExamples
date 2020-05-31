package com.codenjoy.dojo.snake.client;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2018 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.client.WebSocketRunner;
import com.codenjoy.dojo.services.*;
import org.reflections.vfs.Vfs;

import java.util.ArrayList;
import java.util.List;

/**
 * User: your name
 */
public class YourSolver implements Solver<Board> {

    private Dice dice;
    private Board board;

    public YourSolver(Dice dice) {
        this.dice = dice;
    }

    @Override
    public String get(Board board) {
        this.board = board;
        int size = board.size();
        Direction curDirection = board.getSnakeDirection();
        if(null == curDirection){
            System.out.println("NULLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL    ************************");
            curDirection = Direction.RIGHT;
        }

        ArrayList<Direction> allDirs = new ArrayList<Direction>();
        allDirs.add(Direction.LEFT);
        allDirs.add(Direction.RIGHT);
        allDirs.add(Direction.UP);
        allDirs.add(Direction.DOWN);
        // remove inverted direction from all dires.
        if (curDirection.equals(Direction.LEFT)) {
            allDirs.remove(Direction.RIGHT);
        }

        if (curDirection.equals(Direction.RIGHT)) {
            allDirs.remove(Direction.LEFT);
        }
        if (curDirection.equals(Direction.UP)) {
            allDirs.remove(Direction.DOWN);
        }
        if (curDirection.equals(Direction.DOWN)) {
            allDirs.remove(Direction.UP);
        }

        Point currPoint = board.getHead();


        Point nextPoint = getNextPoint(currPoint, curDirection);
        List<Point> barriers = board.getBarriers();

        if (nextPoint.equals(board.getApples().get(0))) {
            //GOAHED
            return curDirection.toString();
        } else {
            curDirection = getBestCurrentDirection(allDirs, curDirection, currPoint, board.getApples().get(0));
            //  list size 2
            nextPoint = getNextPoint(currPoint, curDirection);

            if (!barriers.contains(nextPoint)) {
                //to improve
                return curDirection.toString();
            } else {
                curDirection = getBestCurrentDirection(allDirs, curDirection, currPoint, board.getApples().get(0));
                // list size 1
                nextPoint = getNextPoint(currPoint, curDirection);

                if (!barriers.contains(nextPoint)) {
                    //to improve
                    return curDirection.toString();
                } else {
                    //
                    System.out.println("Ohh GOD..... #############################");

                    return allDirs.get(0).toString();
                }
            }
          //  return  Direction.random().toString();
        }

    }


//
//        if(barriers.contains(nextPoint)){
//            allDirs.remove(curDirection);
//
//            //3-1 = 2
//            curDirection   = getBestCurrentDirection (allDirs, curDirection, currPoint, board.getApples().get(0));
//
//            //curDirection = allDirs.get(0);
//            nextPoint = getNextPoint(currPoint,curDirection);
//
//            if(nextPoint.equals(board.getApples().get(0))){
//                //GOAHED
//                return board.getSnakeDirection().toString();
//            }else if(! barriers.contains(nextPoint)){
//                //to improve
//                return curDirection.toString();
//            }
//
//            //2-1 = 1
//            allDirs.remove(curDirection);
//
//            //curDirection = allDirs.get(0);
//            curDirection   = getBestCurrentDirection (allDirs, curDirection, currPoint, board.getApples().get(0));
//
//            nextPoint = getNextPoint(currPoint,curDirection);
//
//            if(nextPoint.equals(board.getApples().get(0))){
//                //GOAHED
//                return board.getSnakeDirection().toString();
//            }else if(! barriers.contains(nextPoint)){
//                //to improve
//                return curDirection.toString();
//            }

//            System.out.println("Ohh GOD..... #############################");
 //           return Direction.random().toString();
 //       }

        //15
//        //0 14
//        System.out.println(board.toString());
//
//        System.out.println("****************************");
//          System.out.println(board.getBarriers());
//
//        System.out.println("#################");
//
//        return Direction.LEFT.toString();
//       return  Direction.random().toString();
//    }

    private Direction getBestCurrentDirection(ArrayList<Direction> allDirs, Direction curDirection, Point currPoint, Point apple) {

        if(currPoint.getY() > apple.getY() ){
            if(allDirs.contains(Direction.DOWN)){
                allDirs.remove(Direction.DOWN);
                return Direction.DOWN;
            }
        }

        if(currPoint.getY() < apple.getY() ){
            if(allDirs.contains(Direction.UP)){
                allDirs.remove(Direction.UP);
                return Direction.UP;
            }
        }

        if(currPoint.getX() > apple.getX() ){
            if(allDirs.contains(Direction.LEFT)){
                allDirs.remove(Direction.LEFT);
                return Direction.LEFT;
            }
        }

        if(currPoint.getX() < apple.getX() ){
            if(allDirs.contains(Direction.RIGHT)){
                allDirs.remove(Direction.RIGHT);
                return Direction.RIGHT;
            }

        }

        return allDirs.get(0);
    }

    private Point getNextPoint(Point currPoint,Direction direction) {

        Point nextPoint = new PointImpl(-1,-1);

        switch (direction){

            case LEFT:
                nextPoint= new PointImpl(currPoint.getX()-1,currPoint.getY());
                break;
            case RIGHT:
                nextPoint= new PointImpl(currPoint.getX()+1,currPoint.getY());
                break;
            case UP:
                nextPoint= new PointImpl(currPoint.getX(),currPoint.getY()+1);
                break;
            case DOWN:
                nextPoint= new PointImpl(currPoint.getX(),currPoint.getY()-1);
                break;
            case ACT:
                break;
            case STOP:
                break;
        }

        return nextPoint;
    }

    public static void main(String[] args) {
        WebSocketRunner.runClient(
                // paste here board page url from browser after registration
                //"http://10.245.129.28:8080/codenjoy-contest/board/player/z1zr77m7v8oe8vshwy8h?code=8381472009850722471",
                "http://10.245.129.28:8080/codenjoy-contest/board/player/o8muhkz7ld18wh7t5f8l?code=4431762017169215968",
                new YourSolver(new RandomDice()),
                new Board());
    }

}
