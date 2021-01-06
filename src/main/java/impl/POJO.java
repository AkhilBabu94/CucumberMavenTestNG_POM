package impl;

public class POJO {

    String hello ;
    String hi;


    public String getHello() {
        return hello;
    }

    public String getHi() {
        return hi;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public void setHi(String hi) {
        this.hi = hi;
    }

    public String getAll(){
        return this.getHello() + this.getHi();
    }
}
