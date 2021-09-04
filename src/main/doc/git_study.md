# git使用的一些疑惑

origin、upstream的区别
origin 表示源仓库，是git clone的仓库；
upstream 表示为上游仓库,一般为origin fork 的仓库

怎么关联本地分支及远程分支
git branch -u origin/master master (本地分支关联远程分支)





git branch -m fang_family master   (重命名方: fang_family --> master)
git fetch origin
git remote set-head origin -a