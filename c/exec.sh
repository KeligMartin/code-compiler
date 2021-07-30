chmod +rx exec.sh
cd $1
gcc $2.c -o $2 && ./$2