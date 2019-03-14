package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
  public List<Integer> getListByInterval(int left, int right) {
    Stream<Integer> arry;
    if (left <= right) {
      arry = IntStream.rangeClosed(left, right).boxed();
    } else {
      arry = IntStream.rangeClosed(right, left).boxed().sorted(Comparator.reverseOrder());
    }
    return arry.collect(Collectors.toList());
  }

  public List<Integer> getEvenListByIntervals(int left, int right) {
    Stream<Integer> arry;
    if (left <= right) {
      arry = IntStream.rangeClosed(left, right).boxed();
    } else {
      arry = IntStream.rangeClosed(right, left).boxed().sorted(Comparator.reverseOrder());
    }
    return arry.filter(item -> item % 2 == 0).collect(Collectors.toList());
  }

  public List<Integer> popEvenElments(int[] array) {
    return Arrays.stream(array).filter(item -> item % 2 == 0).boxed().collect(Collectors.toList());
  }

  public int popLastElment(int[] array) {
    return array[array.length - 1];
  }

  public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
    List<Integer> arry = new ArrayList<>();
    for (int itemA : firstArray) {
      for (int itemB : secondArray) {
        if (itemA == itemB) {
          arry.add(itemA);
        }
      }
    }
    return arry;
  }

  public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
    List<Integer> first = new ArrayList<>(Arrays.asList(firstArray));
    List<Integer> second = new ArrayList<>(Arrays.asList(secondArray));
    first.addAll(second);
    return first.stream().distinct().collect(Collectors.toList());
  }
}
