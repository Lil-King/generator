<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
		<table class="wc100">
		    <thead>
		    	<tr>
			        <th class="check w3per">
			            <input type="checkbox" id="check_all" class="inp_analog" /><span class="icon ico-checkbox"></span>
			        </th>
			        <th class="serial w5per">序号</th>
	   				<th class="w15per">企业名称</th>
			        <th class="w12per">操作</th>
			  	</tr>
		    </thead>
	    	<tbody>
				<c:forEach items="${list}" var="item" varStatus="vs">  
	            	<tr >
						<td class="check w3per">
		                	<input type="checkbox" name="id" class="inp_analog batch" value="${item.id}" /><span
			                    class="icon ico-checkbox"></span>
			            </td>
			            <td class="serial">
			                ${vs.count+pageInfo.startIndex}
			            </td>
			            <td>
			            	${item.qymc}
			            </td>
						<td>
							<a href="csc/systemconfig/update.do?id=${item.id}" class="update">修改</a>&nbsp;
							<a href="csc/systemconfig/delete.do?id=${item.id}" class="delete">删除</a>&nbsp;
							<a href="csc/systemconfig/view.do?id=${item.id}" class="view">查看</a>
						</td>
					</tr>            
				</c:forEach>
	         	<c:if test="${empty list}">
					<tr>
			        	<td colspan="4" class="t_c">
			                <span class="no-records">暂无数据</span>
			            </td>
			        </tr>
	        	</c:if>
	    	</tbody>
	    </table>
	    <c:if test="${!empty list}">
			<gd:Pager />
			<div class="bot_fun" style="width:300px;">
				<a class="btn" id="batch_delete" href="csc/systemconfig/batchdelete.do">批量删除</a>
			</div>
		</c:if>