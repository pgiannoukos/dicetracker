<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Visits</title>
</head>
<body>
<a href="/">Index</a>
<hr>
<h2>Visits...</h2>
<hr>
<div style="text-align: center">
    <form action="/resetStatistics" method="post">
        <input type="submit" value="Reset Statistics">
    </form>
</div>
<hr>
<#if allVisitResults?has_content>
    <table style="margin-left: auto; margin-right: auto">
        <tr>
            <th>ID</th>
            <th>Type</th>
            <th>Date</th>
        </tr>
        <#list allVisitResults as visitResult>
            <tr>
                <td>${visitResult.id}</td>
                <td>${visitResult.type}</td>
                <td>${visitResult.throwDate}</td>
            </tr>
        </#list>
    </table>
</#if>
</body>
</html>