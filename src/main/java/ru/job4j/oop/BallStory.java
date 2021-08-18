package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        hare.eat(ball);
        ball.escape(hare);
        wolf.eat(ball);
        ball.escape(wolf);
        fox.eat(ball);
        ball.death(fox);
    }
}
