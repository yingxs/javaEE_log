package com.yingxs.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 处理当前用户任务
 * 操作的表：
 * `act_hi_actinst`
 * `act_hi_identitylink`
 * `act_hi_taskinst`
 * `act_ru_execution`
 * `act_ru_identitylink`
 * `act_ru_task`
 */
public class ActivitiCompleteTask {

    // 查询当前用户的任务并处理掉
    public static void main(String[] args) {
        // 1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.得到TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3.查询当前用户任务
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday2")
                .taskAssignee("zhangsan")
                .singleResult();


        // 4.处理任务
        taskService.complete(task.getId());

        // 5.输出任务Id
        System.out.println(task.getId());

    }


    // lisi完成自己的任务
    /*
    public static void main(String[] args) {
        // 1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.得到TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3.处理任务集结合当前用户任务列表的查询操作的话，任务ID：2505
        taskService.complete("5002");

    }*/


    // zhangsan完成自己的任务
    /*
    public static void main(String[] args) {
        // 1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.得到TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3.处理任务集结合当前用户任务列表的查询操作的话，任务ID：2505
        taskService.complete("2505");



    }*/
}
