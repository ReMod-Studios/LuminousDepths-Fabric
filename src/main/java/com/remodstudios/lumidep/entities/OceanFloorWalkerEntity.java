package com.remodstudios.lumidep.entities;

import com.remodstudios.lumidep.util.MafsUtil;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.NoPenaltyTargeting;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.Random;

/*
 * Base class for Isopods and Kreplers
 */
public class OceanFloorWalkerEntity extends WaterCreatureEntity {
    private boolean targetingUnderwater;
    protected final SwimNavigation waterNavigation;
    protected final MobNavigation landNavigation;

    protected OceanFloorWalkerEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new OceanFloorMoveControl(this);
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
        this.waterNavigation = new SwimNavigation(this, world);
        this.landNavigation = new MobNavigation(this, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new OceanFloorWalkerEntity.WanderAroundOnSurfaceGoal(this, 1.0D));
        this.goalSelector.add(5, new OceanFloorWalkerEntity.LeaveWaterGoal(this, 1.0D));
        this.goalSelector.add(6, new OceanFloorWalkerEntity.TargetAboveWaterGoal(this, 1.0D, this.world.getSeaLevel()));
        this.goalSelector.add(7, new WanderAroundGoal(this, 1.0D));
        this.targetSelector.add(1, (new RevengeGoal(this, OceanFloorWalkerEntity.class, GuardianEntity.class, GorgeBeastEntity.class)).setGroupRevenge(ZombifiedPiglinEntity.class));
        this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true, false));
        this.targetSelector.add(3, new FollowTargetGoal<>(this, AxolotlEntity.class, 10, true, false, AxolotlEntity.AXOLOTL_NOT_PLAYING_DEAD));
        this.targetSelector.add(5, new FollowTargetGoal<>(this, TurtleEntity.class, 10, true, false, TurtleEntity.BABY_TURTLE_ON_LAND_FILTER));
    }

    @Override
    public boolean canFly() {
        return !this.isSwimming();
    }

    private boolean isTargetingUnderwater() {
        if (this.targetingUnderwater) {
            return true;
        } else {
            LivingEntity livingEntity = this.getTarget();
            return livingEntity != null && livingEntity.isTouchingWater();
        }
    }

    @Override
    public void travel(Vec3d movementInput) {
        if (this.canMoveVoluntarily() && this.isTouchingWater() && this.isTargetingUnderwater()) {
            this.updateVelocity(0.01F, movementInput);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9D));
        } else {
            super.travel(movementInput);
        }

    }

    @Override
    public void updateSwimming() {
        if (!this.world.isClient) {
            if (this.canMoveVoluntarily() && this.isTouchingWater() && this.isTargetingUnderwater()) {
                this.navigation = this.waterNavigation;
                this.setSwimming(true);
            } else {
                this.navigation = this.landNavigation;
                this.setSwimming(false);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isAiDisabled()) {
            this.setAir(this.getMaxAir());
        }
    }

    protected boolean hasFinishedCurrentPath() {
        Path path = this.getNavigation().getCurrentPath();
        if (path != null) {
            BlockPos blockPos = path.getTarget();
            if (blockPos != null) {
                double d = this.squaredDistanceTo(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                return d < 4.0D;
            }
        }

        return false;
    }

    public void setTargetingUnderwater(boolean targetingUnderwater) {
        this.targetingUnderwater = targetingUnderwater;
    }

    static class OceanFloorMoveControl extends MoveControl {
        private final OceanFloorWalkerEntity oceanFloorWalkerEntity;

        public OceanFloorMoveControl(OceanFloorWalkerEntity oceanFloorWalkerEntity) {
            super(oceanFloorWalkerEntity);
            this.oceanFloorWalkerEntity = oceanFloorWalkerEntity;
        }

        @Override
        public void tick() {
            LivingEntity livingEntity = this.oceanFloorWalkerEntity.getTarget();
            if (this.oceanFloorWalkerEntity.isTargetingUnderwater() && this.oceanFloorWalkerEntity.isTouchingWater()) {
                if (livingEntity != null && livingEntity.getY() > this.oceanFloorWalkerEntity.getY() || this.oceanFloorWalkerEntity.targetingUnderwater) {
                    //this.oceanFloorWalkerEntity.setVelocity(this.oceanFloorWalkerEntity.getVelocity().add(0.0D, 0.002D, 0.0D));
                }

                if (this.state != MoveControl.State.MOVE_TO || this.oceanFloorWalkerEntity.getNavigation().isIdle()) {
                    this.oceanFloorWalkerEntity.setMovementSpeed(0.0F);
                    return;
                }

                double d = this.targetX - this.oceanFloorWalkerEntity.getX();
                double e = this.targetY - this.oceanFloorWalkerEntity.getY();
                double f = this.targetZ - this.oceanFloorWalkerEntity.getZ();
                double g = MathHelper.sqrt(d * d + e * e + f * f);
                e /= g;
                float h = (float) (MathHelper.atan2(f, d) * 57.2957763671875D) - 90.0F;
                this.oceanFloorWalkerEntity.yaw = this.changeAngle(this.oceanFloorWalkerEntity.yaw, h, 90.0F);
                this.oceanFloorWalkerEntity.bodyYaw = this.oceanFloorWalkerEntity.yaw;
                float i = (float) (this.speed * this.oceanFloorWalkerEntity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
                float j = MathHelper.lerp(0.125F, this.oceanFloorWalkerEntity.getMovementSpeed(), i);
                this.oceanFloorWalkerEntity.setMovementSpeed(j);
                this.oceanFloorWalkerEntity.setVelocity(this.oceanFloorWalkerEntity.getVelocity().add((double) j * d * 0.005D, (double) j * e * 0.1D, (double) j * f * 0.005D));
            } else {
                if (!this.oceanFloorWalkerEntity.onGround) {
                    this.oceanFloorWalkerEntity.setVelocity(this.oceanFloorWalkerEntity.getVelocity().add(0.0D, -0.008D, 0.0D));
                }

                super.tick();
            }

        }
    }

    static class WanderAroundOnSurfaceGoal extends Goal {
        private final PathAwareEntity mob;
        private double x;
        private double y;
        private double z;
        private final double speed;
        private final World world;

        public WanderAroundOnSurfaceGoal(PathAwareEntity mob, double speed) {
            this.mob = mob;
            this.speed = speed;
            this.world = mob.world;
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        @Override
        public boolean canStart() {
            if (!this.world.isDay()) {
                return false;
            } else if (this.mob.isTouchingWater()) {
                return false;
            } else {
                Vec3d vec3d = this.getWanderTarget();
                if (vec3d == null) {
                    return false;
                } else {
                    this.x = vec3d.x;
                    this.y = vec3d.y;
                    this.z = vec3d.z;
                    return true;
                }
            }
        }

        @Override
        public boolean shouldContinue() {
            return !this.mob.getNavigation().isIdle();
        }

        @Override
        public void start() {
            this.mob.getNavigation().startMovingTo(this.x, this.y, this.z, this.speed);
        }

        @Nullable
        private Vec3d getWanderTarget() {
            Random random = this.mob.getRandom();
            BlockPos blockPos = this.mob.getBlockPos();

            for (int i = 0; i < 10; ++i) {
                BlockPos blockPos2 = blockPos.add(random.nextInt(20) - 10, 2 - random.nextInt(8), random.nextInt(20) - 10);
                if (this.world.getBlockState(blockPos2).isOf(Blocks.WATER)) {
                    return Vec3d.ofBottomCenter(blockPos2);
                }
            }

            return null;
        }
    }

    static class LeaveWaterGoal extends MoveToTargetPosGoal {
        private final OceanFloorWalkerEntity oceanFloorWalkerEntity;

        public LeaveWaterGoal(OceanFloorWalkerEntity oceanFloorWalkerEntity, double speed) {
            super(oceanFloorWalkerEntity, speed, 8, 2);
            this.oceanFloorWalkerEntity = oceanFloorWalkerEntity;
        }

        @Override
        public boolean canStart() {
            return super.canStart() && !this.oceanFloorWalkerEntity.world.isDay() && this.oceanFloorWalkerEntity.isTouchingWater() && this.oceanFloorWalkerEntity.getY() >= (double) (this.oceanFloorWalkerEntity.world.getSeaLevel() - 3);
        }

        @Override
        public boolean shouldContinue() {
            return super.shouldContinue();
        }

        @Override
        protected boolean isTargetPos(WorldView world, BlockPos pos) {
            BlockPos blockPos = pos.up();
            return world.isAir(blockPos) && world.isAir(blockPos.up()) && world.getBlockState(pos).hasSolidTopSurface(world, pos, this.oceanFloorWalkerEntity);
        }

        @Override
        public void start() {
            this.oceanFloorWalkerEntity.setTargetingUnderwater(false);
            this.oceanFloorWalkerEntity.navigation = this.oceanFloorWalkerEntity.landNavigation;
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
        }
    }

    static class TargetAboveWaterGoal extends Goal {
        private final OceanFloorWalkerEntity oceanFloorWalkerEntity;
        private final double speed;
        private final int minY;
        private boolean foundTarget;

        public TargetAboveWaterGoal(OceanFloorWalkerEntity oceanFloorWalkerEntity, double speed, int minY) {
            this.oceanFloorWalkerEntity = oceanFloorWalkerEntity;
            this.speed = speed;
            this.minY = minY;
        }

        @Override
        public boolean canStart() {
            return !this.oceanFloorWalkerEntity.world.isDay() && this.oceanFloorWalkerEntity.isTouchingWater() && this.oceanFloorWalkerEntity.getY() < (double) (this.minY - 2);
        }

        @Override
        public boolean shouldContinue() {
            return this.canStart() && !this.foundTarget;
        }

        @Override
        public void tick() {
            if (this.oceanFloorWalkerEntity.getY() < (double) (this.minY - 1) && (this.oceanFloorWalkerEntity.getNavigation().isIdle() || this.oceanFloorWalkerEntity.hasFinishedCurrentPath())) {
                Vec3d vec3d = NoPenaltyTargeting.find(this.oceanFloorWalkerEntity, 4, 8, new Vec3d(this.oceanFloorWalkerEntity.getX(), this.minY - 1, this.oceanFloorWalkerEntity.getZ()), 1.5707963705062866D);
                if (vec3d == null) {
                    this.foundTarget = true;
                    return;
                }

                this.oceanFloorWalkerEntity.getNavigation().startMovingTo(vec3d.x, vec3d.y, vec3d.z, this.speed);
            }

        }

        @Override
        public void start() {
            this.oceanFloorWalkerEntity.setTargetingUnderwater(true);
            this.foundTarget = false;
        }

        @Override
        public void stop() {
            this.oceanFloorWalkerEntity.setTargetingUnderwater(false);
        }
    }
}
