/*
package com.component.test.controller;

*/
/**
 * @Author: bao
 * @Date: 2019/11/29 13:20
 *//*

public class TestThread {
    */
/**根据活动标志重置活动用户信息*//*

    public int resetByActivitySign(final String activitySign, final HdUser hdUser) {
        String key = "getDrawWinRecord" + hdUser.getUserId();
        String uuid = UUID.randomUUID().toString();

        try {
// 加锁（锁个人积分/机会）
            while (!redisLockImpl.lock(key, 30 * 1000, uuid)) {
                Thread.sleep(100);
            }

// 执行sql
            Session session = null;
            Transaction tx = null;
            try {
                session = this.getSessionFactory().getCurrentSession();
                tx = session.beginTransaction();

//获取ResetUser类的所有方法，存放入数组
                ResetUser ResetUser = new ResetUser();
                Method[] methods= ResetUser.getClass().getDeclaredMethods();
                for (final Method method : methods) {
                    System.out.println("方法名："+method.getName());
//获取本方法所有参数类型，存入数组
                    Class<?>[] getTypeParameters = method.getParameterTypes();
                    if(getTypeParameters.length==0){
                        System.out.println("此方法无参数");
                    }
                    for (Class<?> class1 : getTypeParameters) {
                        String parameterName = class1.getName();
                        System.out.println("参数类型："+parameterName);
                    }
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                method.invoke(new ResetUser(), new Object[]{activitySign, hdUser.getUserName()});
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();

                    System.out.println("****************************");
                }

                tx.commit();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                tx.rollback();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return 102;
        } finally {
// 解锁个人
            Boolean result = redisLockImpl.unlock(key, uuid);
            if (!result) {
                log.info("getExchangeWinRecord解锁失败2。");
            }
            return 00;
        }
    }
}

*/
