package app.Error;

import app.Observer.Publisher;
import app.Observer.Subscriber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ErrorFactory implements Publisher {
    private static ErrorFactory instance;
    private List<Subscriber> subs;
    private String msg;

    public void baciError(String errorName) {
        if(errorName.equals("ErrorInvalidPath")){
            notifySubscribers(new ErrorInvalidPath());
        }else if(errorName.equals("ErrorNothingSelected")){
            notifySubscribers(new ErrorNothingSelected());
            System.out.println("napravio se error");
        }else if(errorName.equals("ErrorWrongColorValue")){
            notifySubscribers(new ErrorWrongColorValue());
        }else if(errorName.equals("ErrorSlideChild")){
            notifySubscribers(new ErrorSlideChild());
        }

    }

    private ErrorFactory() {
    }
    public static ErrorFactory getInstance() {
        if (instance == null) {
            instance = new ErrorFactory();
            instance.initialise();
        }
        return instance;
    }
    private void initialise(){
        subs=new LinkedList<>();
        msg="";
    }

    public void setMsg(String msg) {
        this.msg = msg;
        notifySubscribers(this);
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public void addSubscriber(Subscriber sub) {
        if(sub == null)
            return;
        if(this.subs ==null)
            this.subs = new ArrayList<>();
        if(this.subs.contains(sub))
            return;
        this.subs.add(sub);
    }

    @Override
    public void removeSubscriber(Subscriber sub) {

    }

    @Override
    public void notifySubscribers(Object notification) {
        if(notification == null || this.subs == null || this.subs.isEmpty())
        return;
        for(int i=0;i<subs.size();i++){
            subs.get(i).update(notification);
        }
    }
}
