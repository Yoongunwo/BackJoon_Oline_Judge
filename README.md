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

#### 
## ref:
* "BackJoon Oline Judge" acmicpc.net https://www.acmicpc.net/
* "유클리드 호제법," namu.wiki, https://namu.wiki/w/%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C%20%ED%98%B8%EC%A0%9C%EB%B2%95
