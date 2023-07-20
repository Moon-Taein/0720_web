<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두 수의 합은?(Static)</title>
</head>
<body>
	<main>
		<fieldset>
		<legend>simple 계산기</legend>
		<form action="http://localhost:8080/0720_4/calcul/sum" method="post">
			<h3>더하기</h3>
			<input type="number" name="num1" size="15" />
			<span> + </span>
			<input type="number" name="num2" size="15" />
			<input type="submit" value="더하기" />
		</form>
		<form action="http://localhost:8080/0720_4/calcul/minus" method="post">
			<h3>빼기</h3>
			<input type="number" name="num1" size="15" />
			<span> - </span>
			<input type="number" name="num2" size="15" />
			<input type="submit" value="빼기" />
		</form>
		<form action="http://localhost:8080/0720_4/calcul/multiply" method="post">
			<h3>곱하기</h3>
			<input type="number" name="num1" size="15" />
			<span> * </span>
			<input type="number" name="num2" size="15" />
			<input type="submit" value="곱하기" />
		</form>
		</fieldset>
		<fieldset>
			<legend> 에러 메시지 </legend>			
			<h2 align="center"> ${ result }</h2>
		</fieldset>
		<fieldset>
			<legend> 계산 값 </legend>			
			<h2 align="center"> 더하기 : ${ result1 }</h2>
			<h2 align="center"> 빼기 : ${ result2 }</h2>
			<h2 align="center"> 곱하기 : ${ result3 }</h2>
		</fieldset>
		<fieldset>
			<legend> 제대로된 실행 횟수 </legend>
			<form action="http://localhost:8080/0720_4/reset" method="post">
			<h2 align="center"> ${ count }</h2>
			<input type="submit" value="초기화" />
			</form>
		</fieldset>
	</main>
</body>
</html>