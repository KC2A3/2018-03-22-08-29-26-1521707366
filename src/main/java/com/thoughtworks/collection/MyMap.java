package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

  List<Integer> array;
  private String[] letters =
      new String[] {
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
        "s", "t", "u", "v", "w", "x", "y", "z"
      };
  private List<String> letterList = Arrays.asList(letters);

  public MyMap(List<Integer> array) {
    this.array = array;
  }

  public List<Integer> getTriple() {
    return this.array.stream().map(item -> item * 3).collect(Collectors.toList());
  }

  public List<String> mapLetter() {
    return this.array.stream()
        .map(item -> this.letterList.get(item - 1))
        .collect(Collectors.toList());
  }

  public List<String> mapLetters() {
    List<String> arrayOfLetter = new ArrayList<>();
    String letter;
    for (Integer item : array) {
      int first = (item - 1) / this.letters.length;
      int second = (item - 1) % this.letters.length;
      if (first < 1) {
        letter = this.letters[second];
      } else {
        letter = this.letters[first - 1] + this.letters[second];
      }
      arrayOfLetter.add(letter);
    }
    return arrayOfLetter;
  }

  public List<Integer> sortFromBig() {
    return this.array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
  }

  public List<Integer> sortFromSmall() {
    return this.array.stream().sorted().collect(Collectors.toList());
  }
}
