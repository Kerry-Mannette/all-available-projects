using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using RazorPagesRental.Models;

namespace RazorPagesRental.Data
{
    public class RazorPagesCarsContext : DbContext
    {
        public RazorPagesCarsContext (DbContextOptions<RazorPagesCarsContext> options)
            : base(options)
        {
        }

        public DbSet<RazorPagesRental.Models.Cars> Cars { get; set; } = default!;
    }
}
