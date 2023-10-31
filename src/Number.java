public class Number {
    int x;

    public Number(int x) {
        this.x = x;
    }

    public void setDenary(int x) {
        this.x = x;
    }
    public int getDenary(){
        return this.x;
    }

    public String getSignedBinary() {
        String s = "";
        int pn = 0;
        while(((int)Math.pow(2,pn)) <= Math.abs(x)){
            pn++;
        }
        int pow = (int) Math.pow(2, pn-1), target = 0;
        if (x < 0) {
            target = (int) ((Math.pow(2, pn)) + x);
            s += '1';
        } else {
            target = x;
            s += '0';
        }
        for (int i = 1; i <= pn; i++) {
            if (target >= pow) {
                target -= pow;
                s += '1';
            } else {
                s += '0';
            }
            pow /= 2;
        }
        return s;
    }
    public String getHexadecimal(){
        String s = getSignedBinary();
        String ans = "";
        int b = 0, c = 0;
        int rem=s.length() % 4;
        if (rem != 0){
            b = 1;
            c = rem;
        }
        else{
            c = 4;
        }
        for(int i = 0; i<s.length()/4+b; i++){
            int num = 0;
            for(int j = 3; j >= 0; j--){
                if(i == 0 &&rem!=0&&j >= rem) continue;
                if(s.charAt((i-1)*4+(3-j)+c)=='1'){
                    num += ((int)Math.pow(2,j));
                }
            }
            if(num == 0)continue;
            if(num <= 9){
                ans += (char)(num+'0');
            }
            else{
                num -= 10;
                ans += (char)(num+'A');
            }
        }
        return ans;
    }
    public void negate(){
        this.x *= -1;
    }
    public String toString(){
        String s = "Number{denary="+Integer.toString(x)+" binary="+getSignedBinary()+" hexadecimal="+getHexadecimal()+"}";
        return s;
    }
}
