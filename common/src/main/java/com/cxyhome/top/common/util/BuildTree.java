package com.cxyhome.top.common.util;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 树形生成
 */
public class BuildTree {
	/**
	 * 
	 * @param nodes 生成树形的list(必须包含id paentId俩个参数)
	 * @return
	 * 生成树形并加上顶层
	 */
	public static <T> Tree<T> build(List<Tree<T>> nodes) {

		if (nodes == null) {
			return null;
		}
		List<Tree<T>> topNodes = new ArrayList<Tree<T>>();

		for (Tree<T> children : nodes) {

			String pid = children.getParentId();
			if (pid == null || "0".equals(pid)) {
				topNodes.add(children);

				continue;
			}

			for (Tree<T> parent : nodes) {
				String id = parent.getId();
				if (id != null && id.equals(pid)) {
					parent.getChildren().add(children);
					children.setHasParent(true);
//					parent.setChildren(true);
					parent.setHasChildren(true);
					continue;
				}
			}

		}

		Tree<T> root = new Tree<T>();
		if (topNodes.size() == 1) {
			root = topNodes.get(0);
		} else {
			root.setId("-1");
			root.setParentId("");
			root.setHasParent(false);
//			root.setChildren(true);
			root.setHasChildren(true);
			root.setChecked(true);
			root.setChildren(topNodes);
			root.setText("顶级节点");
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			root.setState(state);
		}

		return root;
	}

	/**
	 * 
	 * @param nodes 生成树形的list(必须包含id paentId俩个参数)
	 * @param idParam 顶层parentId
	 * @return
	 * 通过给的顶层parentId和nodes数据自动生成树形
	 */
	public static <T> List<Tree<T>> buildList(List<Tree<T>> nodes, String idParam) {
		if (nodes == null) {
			return null;
		}
		List<Tree<T>> topNodes = new ArrayList<Tree<T>>();

		for (Tree<T> children : nodes) {

			String pid = children.getParentId();
			if (pid == null || idParam.equals(pid)) {
				topNodes.add(children);

				continue;
			}

			for (Tree<T> parent : nodes) {
				String id = parent.getId();
				if (id != null && id.equals(pid)) {
					parent.getChildren().add(children);
					children.setHasParent(true);
//					parent.setChildren(true);
					parent.setHasChildren(true);
					continue;
				}
			}

		}
		return topNodes;
	}
}
