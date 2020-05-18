package com.jkxy.car.api.controller;

import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("findAll")
    public JSONResult findAll() {
        List<Car> cars = carService.findAll();
        return JSONResult.ok(cars);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @GetMapping("findById/{id}")
    public JSONResult findById(@PathVariable int id) {
        Car car = carService.findById(id);
        return JSONResult.ok(car);
    }

    /**
     * 通过车名查询
     *
     * @param carName
     * @return
     */
    @GetMapping("findByCarName/{carName}")
    public JSONResult findByCarName(@PathVariable String carName) {
        List<Car> cars = carService.findByCarName(carName);
        return JSONResult.ok(cars);
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @GetMapping("deleteById/{id}")
    public JSONResult deleteById(@PathVariable int id) {
        carService.deleteById(id);
        return JSONResult.ok();
    }

    /**
     * 通过id更新全部信息
     *
     * @return
     */
    @PostMapping("updateById")
    public JSONResult updateById(Car car) {
        carService.updateById(car);
        return JSONResult.ok();
    }

    /**
     * 通过id增加
     *
     * @param car
     * @return
     */
    @PostMapping("insertCar")
    public JSONResult insertCar(Car car) {
        carService.insertCar(car);
        return JSONResult.ok();
    }

    /**
     * 车名以及车系进行车辆购买
     *
     * @param car
     * @return
     */
    @PostMapping("buyCarByCarName")
    public JSONResult buyCarByCarName(Car car) {
        int buyNum = car.getStock();
        List<Car> cars = carService.findByCarName(car.getCarName());
        for(Car carTemp : cars){
            if(carTemp.getCarSeries().equals(car.getCarSeries())){
                Car carFactory = carService.findById(carTemp.getId());
                if(carFactory.getStock()<buyNum){
                    return JSONResult.errorMsg("购买数量超出当前库存");
                }else{
                    int ans = carFactory.getStock() - buyNum;
                    carFactory.setStock(ans);
                    carService.updateById(carFactory);
                    return JSONResult.ok();
                }
            }
        }
        return JSONResult.errorMsg("不存在该车");
    }

    /**
     *车系模糊查询
     *
     * @param car
     * @return
     */
    @PostMapping("searchCar")
    public JSONResult searchCar(Car car){
        List<Car> cars = carService.searchByCarName(car);
        List<Car> carResults = new ArrayList<>();

        if(cars.size()<1){
            return JSONResult.ok(cars);
        }else {
            for(int i = 0;i <= 4; i++){
                carResults.add(cars.get(i));
            }
            return JSONResult.ok(carResults);
        }
    }

}
