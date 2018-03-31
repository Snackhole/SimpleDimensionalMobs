package com.snackhole.simpledimensionalmobs.entities.entitymodels;

import com.snackhole.simpledimensionalmobs.entities.EntityEldritchAutomaton;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelEldritchAutomaton extends ModelBase {
    /**
     * The head model for the iron golem.
     */
    public ModelRenderer ironGolemHead;
    /**
     * The body model for the iron golem.
     */
    public ModelRenderer ironGolemBody;
    /**
     * The right arm model for the iron golem.
     */
    public ModelRenderer ironGolemRightArm;
    /**
     * The left arm model for the iron golem.
     */
    public ModelRenderer ironGolemLeftArm;
    /**
     * The left leg model for the Iron Golem.
     */
    public ModelRenderer ironGolemLeftLeg;
    /**
     * The right leg model for the Iron Golem.
     */
    public ModelRenderer ironGolemRightLeg;

    public ModelEldritchAutomaton() {
        this((float) 0);
    }

    public ModelEldritchAutomaton(float scaleFactor) {
        this(scaleFactor, (float) -7);
    }

    public ModelEldritchAutomaton(float scaleFactor, float rotationOffset) {
        this.ironGolemHead = (new ModelRenderer(this)).setTextureSize(128, 128);
        this.ironGolemHead.setRotationPoint(0.0F, 0.0F + rotationOffset, -2.0F);
        this.ironGolemHead.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, -5.5F, 8, 10, 8, scaleFactor);
        this.ironGolemHead.setTextureOffset(24, 0).addBox(-1.0F, -5.0F, -7.5F, 2, 4, 2, scaleFactor);
        this.ironGolemBody = (new ModelRenderer(this)).setTextureSize(128, 128);
        this.ironGolemBody.setRotationPoint(0.0F, 0.0F + rotationOffset, 0.0F);
        this.ironGolemBody.setTextureOffset(0, 40).addBox(-9.0F, -2.0F, -6.0F, 18, 12, 11, scaleFactor);
        this.ironGolemBody.setTextureOffset(0, 70).addBox(-4.5F, 10.0F, -3.0F, 9, 5, 6, scaleFactor + 0.5F);
        this.ironGolemRightArm = (new ModelRenderer(this)).setTextureSize(128, 128);
        this.ironGolemRightArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.ironGolemRightArm.setTextureOffset(60, 21).addBox(-13.0F, -2.5F, -3.0F, 4, 30, 6, scaleFactor);
        this.ironGolemLeftArm = (new ModelRenderer(this)).setTextureSize(128, 128);
        this.ironGolemLeftArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.ironGolemLeftArm.setTextureOffset(60, 58).addBox(9.0F, -2.5F, -3.0F, 4, 30, 6, scaleFactor);
        this.ironGolemLeftLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(128, 128);
        this.ironGolemLeftLeg.setRotationPoint(-4.0F, 18.0F + rotationOffset, 0.0F);
        this.ironGolemLeftLeg.setTextureOffset(37, 0).addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, scaleFactor);
        this.ironGolemRightLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(128, 128);
        this.ironGolemRightLeg.mirror = true;
        this.ironGolemRightLeg.setTextureOffset(60, 0).setRotationPoint(5.0F, 18.0F + rotationOffset, 0.0F);
        this.ironGolemRightLeg.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, scaleFactor);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.ironGolemHead.render(scale);
        this.ironGolemBody.render(scale);
        this.ironGolemLeftLeg.render(scale);
        this.ironGolemRightLeg.render(scale);
        this.ironGolemRightArm.render(scale);
        this.ironGolemLeftArm.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.ironGolemHead.rotateAngleY = netHeadYaw * (float) 0.017453292;
        this.ironGolemHead.rotateAngleX = headPitch * (float) 0.017453292;
        this.ironGolemLeftLeg.rotateAngleX = (float) -1.5 * this.triangleWave(limbSwing, (float) 13) * limbSwingAmount;
        this.ironGolemRightLeg.rotateAngleX = (float) 1.5 * this.triangleWave(limbSwing, (float) 13) * limbSwingAmount;
        this.ironGolemLeftLeg.rotateAngleY = (float) 0;
        this.ironGolemRightLeg.rotateAngleY = (float) 0;
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
        EntityEldritchAutomaton entityEldritchAutomaton = (EntityEldritchAutomaton) entitylivingbaseIn;
        int attackTimer = entityEldritchAutomaton.getAttackTimer();
        if (attackTimer > 0) {
            this.ironGolemRightArm.rotateAngleX = (float) -2 + (float) 1.5 * this.triangleWave((float) attackTimer - partialTickTime, (float) 10);
            this.ironGolemLeftArm.rotateAngleX = (float) -2 + (float) 1.5 * this.triangleWave((float) attackTimer - partialTickTime, (float) 10);
        } else {
            this.ironGolemRightArm.rotateAngleX = ((float) -0.2 + (float) 1.5 * this.triangleWave(limbSwing, (float) 13)) * limbSwingAmount;
            this.ironGolemLeftArm.rotateAngleX = ((float) -0.2 - (float) 1.5 * this.triangleWave(limbSwing, (float) 13)) * limbSwingAmount;
        }
    }

    private float triangleWave(float float1, float float2) {
        return (Math.abs(float1 % float2 - float2 * 0.5F) - float2 * 0.25F) / (float2 * 0.25F);
    }
}
