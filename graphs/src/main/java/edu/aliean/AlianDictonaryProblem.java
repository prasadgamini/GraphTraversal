package edu.aliean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Given a sorted dictionary of an alien language, find order of characters
 * <p>
 * Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.
 * <p>
 * Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
 * Output: Order of characters is 'b', 'd', 'a', 'c'
 * Note that words are sorted and in the given language "baa"
 * comes before "abcd", therefore 'b' is before 'a' in output.
 * Similarly we can find other orders.
 * <p>
 * Input:  words[] = {"caa", "aaa", "aab"}
 * Output: Order of characters is 'c', 'a', 'b'
 */
public class AlianDictonaryProblem {

    Map<Character, Vertex> map = new HashMap<>();
    private  Stack<Vertex> stack = new Stack<>();

    public List<Character> getOrderedChars(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            int j = 0;
            for (; j < words[i].length() && j < words[i + 1].length() && words[i].charAt(j) == words[i + 1].charAt(j); j++)
                ;
            Vertex u;
            if (j < words[i].length()) {
                u = getVertex(words[i].charAt(j));
            } else {
                u = getVertex(words[i].charAt(j-1));
            }

            Vertex v = getVertex(words[i + 1].charAt(j));
            u.setNeighbor(v);

        }

        map.values().forEach(vertex -> {
            if (!vertex.isVisited()) dfs(vertex);
        });

        List<Character> charactersList = new ArrayList<>();
        while (!stack.isEmpty()) {
            charactersList.add(stack.pop().getCh());
        }
        return charactersList;
    }



    private  void dfs(Vertex vertex) {
        vertex.setVisited(true);
        if (vertex.getNeighbor() != null && !vertex.getNeighbor().isVisited()) {
            dfs(vertex.getNeighbor());
        }
        stack.push(vertex);
    }

    private  Vertex getVertex(char ch) {
        if (!map.containsKey(ch)) {
            Vertex v = new Vertex(ch);
            map.put(ch, v);
        }
        return map.get(ch);
    }
}
