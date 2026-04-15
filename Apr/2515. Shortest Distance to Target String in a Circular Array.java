class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        // move left
        int leftSteps=0;
        boolean left=false;
        int index1 = startIndex;
        for(int i=0;i<n;i++){
            if(words[index1].equals(target)){
                left=true;
                break;
            }
            index1 = (index1-1+n)%n;
            leftSteps++;
        }
        // move right
        int rightSteps=0;
        boolean right=false;
        int index2 = startIndex;
        for(int i=0;i<n;i++){
            if(words[index2].equals(target)){
                right=true;
                break;
            }
            index2 = (index2+1)%n;
            rightSteps++;
        }

        return ((right && left)?(Math.min(leftSteps,rightSteps)):-1);
    }
}
