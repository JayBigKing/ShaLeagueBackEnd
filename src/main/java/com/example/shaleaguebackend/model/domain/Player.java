package com.example.shaleaguebackend.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author jay
 * @since 2021-11-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Player")
@ApiModel(value="Player对象", description="")
public class Player extends Model<Player> {

    private static final long serialVersionUID = 1L;

    private String name;

    @TableId("Pid")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long Pid;


    @Override
    protected Serializable pkVal() {
        return this.Pid;
    }

}
