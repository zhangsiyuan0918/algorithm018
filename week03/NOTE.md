学习笔记
递归模板
Python：
def recursion(level, param1, param2, …) :
	# recursion terminator
	if level > MAX_LEVEL:
	process_result
	return
	
	# process logic in current level
	process(level, data …)
	
	# drill down
	self.recursion(level + 1, p1, …)
	
	#reverse the current level status if needed
	
	
Java:
Public void recur(int level, int param) {
	//terminator
	if  (level > MAX_LEVEL) {
		//process result
		return;
	}
	
	//process current logic
	process(level, param);
	
	//drill down
	recur(level : level + 1, newParam);
	
	//restore current status
}
回溯：---->改进版的游戏的SL大法？
			走迷宫？
			做选择--->递归--->撤销选择
backtrack（）
分治：---->可以把一个问题重复拆分成子问题
