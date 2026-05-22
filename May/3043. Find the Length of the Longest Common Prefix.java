class Solution {
    class Trie{
        Trie node[];
        Trie(){
            node = new Trie[10];
        }
    }

    void insert(Trie node,int value){
        Trie temp=node;
        String s = value+"";
        for(char c:s.toCharArray()){
            int index = c-'0';
            if(temp.node[index]==null){
                temp.node[index]=new Trie();
            }
            temp=temp.node[index];
        }
    }

    int search(Trie node,int value){
        int len=0;
        Trie temp = node;
        String s = value+"";
        for(char c:s.toCharArray()){
            int index = c-'0';
            if(temp.node[index]==null){
                break;
            }
            len++;
            temp=temp.node[index];
        }
        
        return len;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie root = new Trie();

        for(int i:arr1){
            insert(root,i);
        }
        int result=0;

        for(int i:arr2){
            result=Math.max(result,Math.max(result,search(root,i)));
        }
        return result;
    }
}
