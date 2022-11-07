# BackJoon_Oline_Judge

---
## Algorithm
### 유클리드 호제법 
1. 개요
    - 두 양의 정수, 혹은 두 다항식의 최대공양수를 구하는 방법으로   
   두 양의 정수 a,b (a > b)에 대하여 a = bq + r ( 0 <= r < b )이라 하면, a,b의 최대공약수는 b,r의 최대공약수와 같다. 즉,   
   <div align="center">gcd(a,b) = gcd(b,r)</div>     
   　　r = 0이라면 a,b의 최대공약수는 b가 된다.
2. 소스코드
```java
int gcd(int a, int b)
{
    int r = a % b;
    if ( r == 0 ) {
      return b;
    }
    return gcd(b,r)
}
```

### 백트래킹
1. 정의
    - 모든 경우의 수를 전부 고려하는 알고리즘. 상태공간을 트리로 나타낼 수 있을 때 적합한 방식이다. 
    일종의 트리 탐색 알고리즘이라고 봐도 된다. 방식에 따라서 DFS, BFS, Best First Search(Heuristic 
    Search)이 있다. 
   
2. 적용
    - 백트래킹은 모든 가능한 경우의 수 중에서 특정한 조건을 만족하는 경우만 살펴 보는 것이다.
    - 즉 답이 될만한지 판단하고 그렇지 않으면 그 부분까지 탐색하는 것을 하지 않고 가지치기하는 것을
    백트래킹이라고 생각하면 된다.
    - 주로 물제 풀이에서는 DFS 등으로 모든 경우의 수를 탐색하는 과정에서 조건문 등을 걸어 답이 절대
    로 될 수 없는 상황을 저으이하고, 그러한 상황일 경우에는 탐색을 중지시킨 뒤 그 이전으로 돌아가서 
    다시 다른 경우를 탐색하게끔 구현할 수 있다.

---
## ref:
* "BackJoon Oline Judge" acmicpc.net https://www.acmicpc.net/
* "유클리드 호제법," namu.wiki, https://namu.wiki/w/%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C%20%ED%98%B8%EC%A0%9C%EB%B2%95
* "백트래킹," namu.wiki, https://namu.wiki/w/%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9
* "알고리즘-백트래킹(Backtracking)의 정의 및 예시문제," chanhuiseok.github.io, https://chanhuiseok.github.io/posts/algo-23/
