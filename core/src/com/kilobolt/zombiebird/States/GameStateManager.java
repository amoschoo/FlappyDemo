package com.kilobolt.zombiebird.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Amos on 10/2/16.
 */
public class GameStateManager {
    private Stack<State> states;
    public GameStateManager(){
        states = new Stack<State>();
    }
    public void push(State state){
        states.push(state);
    }
    public void pop() {
        states.pop().dispose();
    }

    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }
    public void update(float dt){ //take in change in time between renders
        states.peek().update(dt); //.peek to see object at the top of the stack
    }
    public void render(SpriteBatch sb){ //Container for every and renders it into the screen
        states.peek().render(sb);
    }

}
