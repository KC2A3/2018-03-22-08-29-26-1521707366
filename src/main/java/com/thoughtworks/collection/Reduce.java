package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

  List<Integer> arrayList;

  public Reduce(List<Integer> arrayList) {
    this.arrayList = arrayList;
  }

  public int getMaximum() {
    return this.arrayList.stream().max(Integer::compareTo).get();
  }

  public double getMinimum() {
    return this.arrayList.stream().min(Integer::compareTo).get();
  }

  public double getAverage() {
    return this.arrayList.stream().collect(Collectors.averagingDouble(Integer::doubleValue));
  }

  public double getOrderedMedian() {
    throw new NotImplementedException();
  }

  public int getFirstEven() {
    return this.arrayList.stream().filter(item -> item % 2 == 0).findFirst().get();
  }

  public int getIndexOfFirstEven() {
    return this.arrayList.indexOf(this.getFirstEven());
  }

  public boolean isEqual(List<Integer> arrayList) {
    if (this.arrayList.size() != arrayList.size()) {
      return false;
    } else {
      for (int i = 0; i < arrayList.size() - 1; i++) {
        if (this.arrayList.get(i) != arrayList.get(i)) {
          return false;
        }
      }
    }
    return true;
  }

  // 实现接口SingleLink，然后再此函数内使用
  public Double getMedianInLinkList(SingleLink singleLink) {
    this.arrayList.forEach(singleLink::addHeadPointer);
    return this.getOrderedMedian();
  }

  public int getLastOdd() {
    List<Integer> odd =
        this.arrayList.stream().filter(item -> item % 2 == 1).collect(Collectors.toList());
    return odd.get(odd.size() - 1);
  }

  public int getIndexOfLastOdd() {
    return this.arrayList.indexOf(this.getLastOdd());
  }
}
