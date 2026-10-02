class TrafficLight {
    //declare here the attribute color of type int and initialise it to 0
    int color = 0;
    //this is the signature of the method changeColor:
    void changeColor () {
        // increment the value of the attribute color by 1
        color = color ++;
        if (color > 2){
            color = 0;
            }
        else if (color < 0){
            color=0;
        //if the value of attribute color is bigger than 2 or smaller than 0
        //set it to 0
        }
    }
}