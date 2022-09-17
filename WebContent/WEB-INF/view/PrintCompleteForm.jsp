<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
            .btn {
                    position: relative;
                    display: flex;
                    justify-content: space-around;
                    align-items: center;
                    max-width: 240px;
                    padding: 10px 25px;
                    color: #FFF;
                    transition: 0.3s ease-in-out;
                    font-weight: 600;
                    background: #6bb6ff;
                    border-radius: 8px;
                    border-bottom: solid 5px #1d7fde;
                    margin-bottom: 15px;
                    margin-top: 25px;
                    display: inline-block;
                }
                .btn:hover {
                    border-bottom: solid 2px #1d7fde;
                    transform: translateY(3px);
                }

                table{
                    width: 100%;
                    border-collapse: collapse;
                }

                table tr{
                    border-bottom: solid 2px white;
                }

                table tr:last-child{
                    border-bottom: none;
                }

                table th{
                    position: relative;
                    text-align: left;
                    width: 30%;
                    background-color: #52c2d0;
                    color: white;
                    text-align: center;
                    padding: 10px 0;
                }

                table th:after{
                    display: block;
                    content: "";
                    width: 0px;
                    height: 0px;
                    position: absolute;
                    top:calc(50% - 10px);
                    right:-10px;
                    border-left: 10px solid #52c2d0;
                    border-top: 10px solid transparent;
                    border-bottom: 10px solid transparent;
                }

                table td{
                    text-align: left;
                    width: 70%;
                    text-align: center;
                    background-color: #eee;
                    padding: 10px 0;
                }

                input:required{
                    background: #ffcdd2;
                }
                input:valid{
                    background: transparent;
                }
                input:focus{
                    background: #DCEDC8;
                }

                .form-require {
                    border-radius: 5px;
                    margin-right: 10px;
                    padding-top: 5px;
                    padding-bottom: 5px;
                    width: 45px;
                    display: inline-block;
                    text-align: center;
                    background: red;
                    color: #fff;
                    font-size: 12px;
                }
        </style>
    </head>
    <body>
        <header>
            <table>
                <tr>
                    <td>
                        <h1>契約管理・事故受付システム　ハンディー</h1>
                    </td>
                </tr>
            </table>
        </header>
        <main>
        	<form action="" id="finishprint_frm" method="get">
            <table border="1" width="80%">
                <tbody>
                <tr>
                    <td colspan="2">申込書印刷完了</td>
                </tr>
                <tr>
                    <td>印刷連番</td>
                    <td>A000001</td>
                </tr>
                <tr>
                    <td>契約者名</td>
                    <td><c:out value="{contractInfo.getkanaNameForLabel()}" /></td>
                </tr>
                </tbody>
            </table>
            </form>
        </main>
    </body>
</html>