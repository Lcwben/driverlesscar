package com.codingtest.driverlesscar.impl;

import com.codingtest.driverlesscar.common.BusinessValidator;
import com.codingtest.driverlesscar.constants.CommonConst;
import com.codingtest.driverlesscar.exceptions.BusinessException;
import com.codingtest.driverlesscar.interfaces.Car;
import com.codingtest.driverlesscar.utils.CommonUtil;

public class DriverlessCar implements Car {

    private String name;
    private int positionX;
    private int positionY;
    private String orientation;

    public DriverlessCar(String name, int positionX, int positionY, String orientation) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    @Override
    public void move(String command) throws BusinessException {

        //校验传入的命令
        BusinessValidator.validateCommandNotNull(command);
        BusinessValidator.validateCommandContainDelimiter(command, CommonConst.KEY_VALUE_DELIMITER);

        String[] commandArr = command.split(CommonConst.COMMAND_DELIMITER);

        for (int i=0; i<commandArr.length; i++) {
            try {
                doMoveCommand(commandArr[i], CommonConst.POSITION_X_MARK);
                doMoveCommand(commandArr[i], CommonConst.POSITION_Y_MARK);
                doOrientationCommand(commandArr[i], CommonConst.ORIENTATION_MARK);
            } catch (Exception e) {
                throw new BusinessException("Car exception：" + e.getMessage());
            }

            CommonUtil.printObj("Car " + this.name + " stop, now the car position is X:" + this.positionX + ", Y:" + this.positionY + ", orientation:" + this.orientation);

        }

    }

    @Override
    public int getPositionX() {
        return this.positionX;
    }

    @Override
    public int getPositionY() {
        return this.positionY;
    }

    @Override
    public String getOrientation() {
        return this.orientation;
    }

    /**
     * 执行移动命令
     * @param commandNode
     * @param mark
     */
    private void doMoveCommand(String commandNode, String mark) throws BusinessException {
        String forward = commandNode.split(CommonConst.KEY_VALUE_DELIMITER)[0];
        if (forward.toLowerCase().equals(mark.toLowerCase())) {
            int increment = Integer.valueOf(commandNode.split(CommonConst.KEY_VALUE_DELIMITER)[1]);
            CommonUtil.printObj("Car " + this.name + " move, forward:" + mark + ", increment:" + increment);

            if (forward.toUpperCase().equals(CommonConst.POSITION_X_MARK)) {
                this.positionX = this.positionX + increment;
                BusinessValidator.validateCarPosition(this.positionX, CommonConst.POSITION_X_MARK);
            }

            if (forward.toUpperCase().equals(CommonConst.POSITION_Y_MARK)) {
                this.positionY = this.positionY + increment;
                BusinessValidator.validateCarPosition(this.positionY, CommonConst.POSITION_Y_MARK);
            }

            CommonUtil.printObj("then, car " + this.name + " position is X:" + this.positionX + ", Y:" + this.positionY);
        }
    }

    /**
     * 执行转向命令
     * @param commandNode
     * @param mark
     */
    private void doOrientationCommand(String commandNode, String mark) {
        if (commandNode.split(CommonConst.KEY_VALUE_DELIMITER)[0].toLowerCase().equals(mark.toLowerCase())) {
            String orientation = commandNode.split(CommonConst.KEY_VALUE_DELIMITER)[1];
            CommonUtil.printObj("Car " + this.name + " orientation change from:" + this.orientation + " to:" + orientation);
            this.orientation = orientation;
        }
    }

}
