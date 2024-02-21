package com.example.p1_1202416_1191360_s1;

import java.util.*;
class State {
    int missionariesOnRight;
    int cannibalsOnRight;
    String boatPosition;
    int missionariesOnLeft;
    int cannibalsOnLeft;
    State parent;

    State(int missionariesOnRight, int cannibalsOnRight, String boatPosition, int missionariesOnLeft, int cannibalsOnLeft) {
        this.missionariesOnRight = missionariesOnRight;
        this.cannibalsOnRight = cannibalsOnRight;
        this.boatPosition = boatPosition;
        this.missionariesOnLeft = missionariesOnLeft;
        this.cannibalsOnLeft = cannibalsOnLeft;
    }

    boolean isValidState() {
        return missionariesOnRight >= 0 && cannibalsOnRight >= 0 &&
                missionariesOnLeft >= 0 && cannibalsOnLeft >= 0 &&
                (missionariesOnRight == 0 || missionariesOnRight >= cannibalsOnRight) &&
                (missionariesOnLeft == 0 || missionariesOnLeft >= cannibalsOnLeft);
    }

    boolean goalTest() {
        return missionariesOnRight == 0 && cannibalsOnRight == 0 &&
                boatPosition == "left" && missionariesOnLeft == 3 && cannibalsOnLeft == 3;
    }

    @Override
    public String toString() {
        return "(" + missionariesOnLeft + ", " + cannibalsOnLeft + ", " +
                boatPosition + ", " + missionariesOnRight + ", " + cannibalsOnRight + ")";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        State otherState = (State) obj;
        return missionariesOnRight == otherState.missionariesOnRight &&
                cannibalsOnRight == otherState.cannibalsOnRight &&
                boatPosition == otherState.boatPosition &&
                missionariesOnLeft == otherState.missionariesOnLeft &&
                cannibalsOnLeft == otherState.cannibalsOnLeft;
    }

    @Override
    public int hashCode() {
        return Objects.hash(missionariesOnRight, cannibalsOnRight, boatPosition, missionariesOnLeft, cannibalsOnLeft);
    }
}

