<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <a href="page/_	createProduct.jsp" class="btn btn-primary">add</a>
    <div class="card" style="width: 18rem;">
  <img src="https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/03/09/image-removebg-preview-2.png" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Iphone 13 promax</h5>
    <p class="card-text">12.000 đ</p>
    <p class="card-text">Đã được nâng cấp về chất lẫn lượng</p>
    <a href="#" class="btn btn-primary">Đặt hàng</a>
  </div>
   <c:forEach items="${productList}" var="product" >
          <tr>
             <td>${product.code}</td>
             <td>${product.name}</td>
             <td>${product.price}</td>
             <td>${product.description}</td>
             <td>
                <a href="editProduct?code=${product.code}">Edit</a>
             </td>
             <td>
                <a href="deleteProduct?code=${product.code}">Delete</a>
             </td>
          </tr>
       </c:forEach>
</div>