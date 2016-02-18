<%--
  Created by IntelliJ IDEA.
  User: 44247
  Date: 2016/2/3 0003
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title> DrugBox-API 1.0 </title>
  </head>
  <body>
  <div align="center"> <h1>DrugBox-API 1.0</h1> </div>
  <h2 align="center">MedicineRQcodeURL(二维码图片): http://drugbox.coding.io/medicine/Medicine_QRcode/$medicineId$.jpg </h2>
  <h2 align="center">MedicinePicURL(药品图片): http://drugbox.coding.io/medicine/Medicine_Picture/$medicineId$.jpg </h2>
  <h2 align="center">MedicineInfoURL（获取药品信息）: http://drugbox.coding.io/medicine/medicineinfo.do?id=$medicineId$ </h2>
  <h2 align="center">UserloginURL（用户登录：需要用json传数据）: http://drugbox.coding.io/user/login.do </h2>
  </body>
</html>
