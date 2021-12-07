package com.example.shaleaguebackend.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.example.shaleaguebackend.model.MyTime.MyTimeHelp;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author lxp
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Admin对象", description="")
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @TableField("loginName")
    private String loginName;

    private String password;


    @TableField("lastLoginTime")
    private LocalDateTime lastLoginTime;

    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public void setOnlyId(Long id){
        this.id = id;
        this.lastLoginTime = MyTimeHelp.getNowDateTime();
        this.loginName = "";
        this.password = "";
        this.remark = "";
    }

}
