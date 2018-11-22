package chencj.cc.oa.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import chencj.cc.oa.entity.Department;


public class TreeDepartmentUtils {

	/*public static void main(String[] args) {
		List<Department> treeList = new ArrayList<>();
		List<Department> topList = new ArrayList<>();
		Department department1 = new Department();
		department1.setDe_name("开发部门");
		
		Department department2 = new Department();
		department2.setDe_name("测试部门");
		
		Department department3 = new Department();
		department3.setDe_name("行政部门");
		
		Department department4 = new Department();
		department4.setDe_name("开发一部");
		Department department5 = new Department();
		department5.setDe_name("开发二部");
		treeList.add(department4);
		treeList.add(department5);
		
		department1.setDe_children(new HashSet<>(treeList));
		
		topList.add(department1);
		topList.add(department2);
		topList.add(department3);
		getShowTree(topList, "┣");
		for (Department department : topList) {
			System.out.println(department.getDe_name());
			for (Department _department : department.getDe_children()) {
				System.out.println(_department.getDe_name());
			}
		}
	}
	public static void getTree(List<Department> treeList ,List<Department> topList,String prefix){
		for (Department department : topList) {
			if(department.equals(treeList.get(0).getDe_parent())){
				department.setDe_children(new HashSet<>(treeList));
			}
		}
		getShowTree(topList, prefix);
	}*/
	
	public static List<Department> getShowTree(Collection<Department> topList){
		List<Department> treeList = new ArrayList<>();
		getShowTree(topList,treeList, "┣");
		return treeList;
	}
	
	public static void getShowTree(Collection<Department> topList, List<Department> treeList,String prefix) {
		// TODO Auto-generated method stub
		for (Department department : topList) {
			//System.out.println(prefix+department.getDe_name());
			Department _deDepartment = new Department();
			BeanUtils.copyProperties(department, _deDepartment);
			_deDepartment.setDe_name(prefix+department.getDe_name());
			treeList.add(_deDepartment);
			Set<Department> children = department.getDe_children();
			getShowTree(children,treeList, "　　"+prefix);
		}

	}
}
