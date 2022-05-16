<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Visits</title>
</head>
<body>
<b><a href="/">Index</a></b>
|
<a href="/diceTracker">Dice Tracker</a>
|
<a href="/animalDiceTracker">Animal Dice Tracker</a>
|
<a href="/shapeDiceTracker">Shape Dice Tracker</a>
|
<a href="/viewStatistics">Visits</a>
|
<a href="/resetStatistics">Reset Statistics</a>
<hr>
<h2>Visits...</h2>
<hr>
<#if allVisitResults?has_content>
    <table style="margin-left: auto; margin-right: auto">
        <tr>
            <th>Type</th>
            <th>Amount</th>
        </tr>
        <#list allVisitResults as visitResult>
            <tr>
                <td>${visitResult.type}</td>
                <td>${visitResult.amount}</td>
            </tr>
        </#list>
    </table>
<#else>
    <h2 style="text-align:center;">
        No visits available
    </h2>
</#if>
</body>
</html>