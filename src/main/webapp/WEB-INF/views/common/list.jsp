<table id="dg${random}" class="easyui-datagrid" title="" style="width:auto;"
	   data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				remoteSort:false,
				url:'${basePath }/${url}',
				onClickRow: onClickRow,
				pagination:true,
				loadFilter:pagerFilter,
				pageSize:10,
				rowStyler: rowStyler,
				onHeaderContextMenu:onHeaderContextMenu,
				onSortColumn:onSortColumn
			">
	<thead>
	<tr>
		<c:forEach items="${commentList }" var="comm"  varStatus="num">
			<c:choose>
				<c:when test="${comm.name == 'id' }">
					<th data-options="field:'${comm.name}'" style="font-weight: bold;"><a title="${comm.comment}">id</a></th>
				</c:when>
				<c:otherwise>
					<th data-options="field:'${comm.name}',editor:'${comm.dataType }',sortable:'true',styler:cellStyler,sorter:sorter"  >
						<c:choose>
							<c:when test="${comm.comment != ''}">
								<a title="${comm.comment}(${comm.name })">${comm.comment}</a>
							</c:when>
							<c:otherwise>
								<a title="${comm.name}">${comm.name}</a>
							</c:otherwise>
						</c:choose>
					</th>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</tr>
	</thead>

</table>