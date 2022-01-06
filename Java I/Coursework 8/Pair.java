// 13706342
// SamClendenan@iCloud.com

class Pair<A, B>{
    private A firstVar;
    private B secondVar;

    public Pair(A firstVar, B secondVar){
        this.firstVar = firstVar;
        this.secondVar = secondVar;
    }

    public A getA(){
        return firstVar;
    }
    public B getB(){
        return secondVar;
    }

    public boolean containedIn(Object newPair){

        if((newPair.equals(this.firstVar)) || (newPair.equals(this.secondVar))) {
            return true;
        }
        else{
            return false;
        }

        }
}
