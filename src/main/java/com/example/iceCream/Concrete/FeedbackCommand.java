package com.example.iceCream.Concrete;

import com.example.iceCream.Interfaces.Command;

public class FeedbackCommand implements Command {
    private DataStore dataStore;
    private Feedback feedback;

    public FeedbackCommand(Feedback feedback, DataStore dataStore)
    {
        this.feedback = feedback; this.dataStore = dataStore;
    }
    @Override
    public void execute() {
        System.out.println("Creating FeedBack");
        this.dataStore.getFeedbacks().put(feedback.getId(),feedback);
    }
}