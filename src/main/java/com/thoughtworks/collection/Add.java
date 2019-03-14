package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
  public int getSumOfEvens(int leftBorder, int rightBorder) {
    int first;
    int last;
    if (leftBorder <= rightBorder) {
      first = leftBorder;
      last = rightBorder;
    } else {
      first = rightBorder;
      last = leftBorder;
    }
    return IntStream.rangeClosed(first, last).filter(item -> item % 2 == 0).sum();
  }

  public int getSumOfOdds(int leftBorder, int rightBorder) {
    int first;
    int last;
    if (leftBorder <= rightBorder) {
      first = leftBorder;
      last = rightBorder;
    } else {
      first = rightBorder;
      last = leftBorder;
    }
    return IntStream.rangeClosed(first, last).filter(item -> item % 2 == 1).sum();
  }

  public int getSumTripleAndAddTwo(List<Integer> arrayList) {
    return arrayList.stream().map(item -> item * 3 + 2).reduce(0, (a, b) -> a + b);
  }

  public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
    List<Integer> arry = new ArrayList<>();
    for (Integer item : arrayList) {
      if (item % 2 == 1) {
        arry.add(item * 3 + 2);
      } else {
        arry.add(item);
      }
    }
    return arry;
  }

  public int getSumOfProcessedOdds(List<Integer> arrayList) {
    return arrayList.stream().filter(item -> item % 2 == 1).reduce(0, (a, b) -> a + b * 3 + 5);
  }

  public double getMedianOfEvenIndex(List<Integer> arrayList) {
    List<Integer> evenArry =
        arrayList.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());
    double result = 0;
    return result;
  }

  public double getAverageOfEvenIndex(List<Integer> arrayList) {
    return arrayList.stream()
        .filter(item -> item % 2 == 0)
        .collect(Collectors.averagingInt(Integer::intValue));
  }

  public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
    return arrayList.stream()
        .filter(item -> item % 2 == 0)
        .collect(Collectors.toList())
        .contains(specialElment);
  }

  public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
    return arrayList.stream().filter(item -> item % 2 == 0).distinct().collect(Collectors.toList());
  }

  public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
    List<Integer> evenArry =
        arrayList.stream().filter(item -> item % 2 == 0).sorted().collect(Collectors.toList());
    List<Integer> oddArry =
        arrayList.stream()
            .filter(item -> item % 2 == 1)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    evenArry.addAll(oddArry);
    return evenArry;
  }

  public List<Integer> getProcessedList(List<Integer> arrayList) {
    List<Integer> arry = new ArrayList<>();
    for (int i = 0; i < arrayList.size() - 1; i++) {
      arry.add((arrayList.get(i) + arrayList.get(i + 1)) * 3);
    }
    return arry;
  }
}
